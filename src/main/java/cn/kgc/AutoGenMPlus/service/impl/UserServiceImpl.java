package cn.kgc.AutoGenMPlus.service.impl;

import cn.kgc.AutoGenMPlus.domain.User;
import cn.kgc.AutoGenMPlus.dao.UserMapper;
import cn.kgc.AutoGenMPlus.service.USERervice;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Try
 * @since 2020-06-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements USERervice {

}
