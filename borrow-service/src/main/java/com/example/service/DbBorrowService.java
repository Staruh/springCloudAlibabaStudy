package com.example.service;

import com.example.entity.DbBorrow;
import com.example.entity.borrowDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (DbBorrow)表服务接口
 *
 * @author makejava
 * @since 2023-05-25 13:02:27
 */
public interface DbBorrowService {

    borrowDetail getBorrowDetailById(Integer uid);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DbBorrow queryById(Integer id);

    /**
     * 分页查询
     *
     * @param dbBorrow 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<DbBorrow> queryByPage(DbBorrow dbBorrow, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param dbBorrow 实例对象
     * @return 实例对象
     */
    DbBorrow insert(DbBorrow dbBorrow);

    /**
     * 修改数据
     *
     * @param dbBorrow 实例对象
     * @return 实例对象
     */
    DbBorrow update(DbBorrow dbBorrow);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
