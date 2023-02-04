package in.das.app.mapper;

import in.das.app.model.pojo.Todo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface TodoMapper {

    Todo getTodo(@Param("id") int id);

    @Select("select * from todos")
    List<Todo> fetchAllTodo();

    @Insert("insert into todos (id, user_id, title, completed) values (#{todo.id}, #{todo.userId}, #{todo.title}, #{todo.completed})")
    void insertTodo(@Param("todo") final Todo todo);
}
