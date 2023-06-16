package com.example.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSONObject;
import com.example.entity.DbBorrow;
import com.example.entity.borrowDetail;
import com.example.service.DbBorrowService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collections;

/**
 * (DbBorrow)表控制层
 *
 * @author makejava
 * @since 2023-05-25 13:02:27
 */
@RestController
@RequestMapping("dbBorrow")
public class DbBorrowController {
    /**
     * 服务对象
     */
    @Resource
    private DbBorrowService dbBorrowService;

    @RequestMapping("/blocked")
    JSONObject blocked() {
        JSONObject object = new JSONObject();
        object.put("code", 403);
        object.put("success", false);
        object.put("message", "信息请求过快");
        return object;
    }

    /**
     * 分页查询
     *
     * @param dbBorrow    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<DbBorrow>> queryByPage(DbBorrow dbBorrow, PageRequest pageRequest) {
        return ResponseEntity.ok(this.dbBorrowService.queryByPage(dbBorrow, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param uid 用户id
     * @return 单条数据
     */
    @GetMapping("{uid}")
    public ResponseEntity<borrowDetail> queryById(@PathVariable("uid") Integer uid) {
        return ResponseEntity.ok(this.dbBorrowService.getBorrowDetailById(uid));
    }

    /**
     * 新增数据
     *
     * @param dbBorrow 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<DbBorrow> add(DbBorrow dbBorrow) {
        return ResponseEntity.ok(this.dbBorrowService.insert(dbBorrow));
    }

    /**
     * 编辑数据
     *
     * @param dbBorrow 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<DbBorrow> edit(DbBorrow dbBorrow) {
        return ResponseEntity.ok(this.dbBorrowService.update(dbBorrow));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.dbBorrowService.deleteById(id));
    }

}

