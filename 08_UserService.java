package service;

import java.sql.ResultSet;

import dao.DBConnection;

public class UserService {
	/*
	 * Service: 服务 业务 
	 * MVC模型: 
	 */
	DBConnection db=new DBConnection();
	//添加
	public void insert(String[] param) {
		String sql="insert into user(name,sex) values(?,?)";
		db.doSQL(sql,param);
		int i=db.getUpCount();
		if (i!=-1) {
			System.out.println("添加成功!");
		} else {
			System.out.println("添加失败!");
		}
	}
	//修改
	public void update(String[] param) {
		String sql="update user set name=?,sex=? where id=?";
		db.doSQL(sql,param);
		int i=db.getUpCount();
		if (i!=-1) {
			System.out.println("修改成功!");
		} else {
			System.out.println("修改失败!");
		}
	}
	//删除
	public void delete(String[] param) {
		String sql="delete from user where id=?";
		db.doSQL(sql,param);
		int i=db.getUpCount();
		if (i!=-1) {
			System.out.println("删除成功!");
		} else {
			System.out.println("删除失败!");
		}
	}
	//查询
	public void select(String[] param) throws Exception{
		String sql="select * from user";
		db.doSQL(sql,param);
		ResultSet rs=db.getRS();
		if (rs!=null) {//含有集合对象: 空集合 或 含有数据
			rs.last();//将指针移动到末行
			int rowNum=rs.getRow();//获得当前行的行号
			if (rowNum>0) {//至少含有1条数据
				rs.beforeFirst();
				while (rs.next()) {//将指针向下移动一行,若含有数据将返回true,否则返回false
					//根据表字段名,获得当前行的指定字段的值
					System.out.println("id:"+rs.getString("id"));
					System.out.println("name:"+rs.getString("name"));
					System.out.println("sex:"+rs.getString("sex"));
				}
			} else {//空集合
				System.out.println("对比起,没有您要查询的数据.....");
			}
		} else {
			System.out.println("查询异常....");
		}
	}
	public static void main(String[] args) throws Exception {
		UserService service=new UserService();
		String[] params={"zhangsan","男"};
		service.select(new String[0]);
		//service.insert(params);
		//service.update();
		//service.delete();
		
	}
}
