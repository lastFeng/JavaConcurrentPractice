package designPattern.struct.proxy.design.agent;

public interface IUserDao {
    @Select("select userName from user where id = #{uId}")
    String queryUserInfo(String uId);
}
