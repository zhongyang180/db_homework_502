package org.scu_db.demo.Repository;

import org.scu_db.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    //继承于JpaRepository,其中Title为对应的实体类，String为实体类主键属性

    Book findBooksByBookId(Integer bookId);

    @Query(value = "select * from book where book_id =?1", nativeQuery = true)
    List<Book> findBookByIdUseSql(Integer book_id);

    @Query(value = "select count(*)\n" +
            "  from book\n" +
            "  where callnumber='Call123';\n", nativeQuery = true)
    Integer findCallNumber();
    @Query(value = " select callnumber\n" +
            "  from book\n" +
            "  group by callnumber\n" +
            "    having count(*) < 3;\n", nativeQuery = true)
    List<String> findSomeOfCallNunber();

    @Query(value = "select Book_ID from book ", nativeQuery = true)
    List<Integer> findAllBook_id();
    //设置事务注解，当操作失败时进行回滚
    @Transactional
    void deleteBookByBookId(Integer bookId);

}
