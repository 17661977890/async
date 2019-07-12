package com.example.async.service;

import com.example.async.entity.User1;
import com.example.async.entity.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 业务实现类---利用缓存
 * @Author 彬
 * @Date 2019/7/11
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * @CachePut(value = "user",key = "#user.id")  缓存新增或修改的数据到缓存，缓存名称为user key为其id
     *
     * 因为案例表有外键约束，注意插入的外键值，是否在主表存在
     * @param user
     * @return
     */
    @Override
    @CachePut(value = "user",key = "#user.id")
    public User1 save(User1 user) {
        User1 user1 = userRepository.save(user);
        log.info("为id、key为"+user1.getId()+"数据做了缓存");
        return user1;
    }

    /**
     *@CacheEvict(value = "user") 删除缓存名为user 的缓存
     * @param id
     */
    @Override
    @CacheEvict(value = "user")
    public void remove(Integer id) {
        log.info("删除id、key为"+id+"的数据缓存");
        userRepository.deleteById(id);
    }

    /**
     * @Cacheable(value = "user",key = "#user.id") 缓存key id 的数据到缓存user中
     *注解的属性key：
     * 使用方法参数及它们对应的属性。使用方法参数时我们可以直接使用“#参数名”或者“#p参数index”
     * Spring还为我们提供了一个root对象可以用来生成key 可以获取方法名，参数等
     *
     * ----看日志效果：如果查询条件不变化，第二次查询不会答应sql日志，直接取缓存中数据，变化 才会重新查sql
     * @param user
     * @return
     */
    @Override
    @Cacheable(value = "user",key = "#root.args[0]")
    public List<User1> findOne(User1 user) {
        Example<User1> example = Example.of(user);
        List<User1> user1 = userRepository.findAll(example);
        log.info("为id、key为"+user.toString()+"数据做了缓存");
        return user1;
    }
}
