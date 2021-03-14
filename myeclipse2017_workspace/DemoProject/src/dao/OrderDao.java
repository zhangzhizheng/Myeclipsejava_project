package dao;

import java.util.List;

import domain.Order;
/**
 * 订单接口
 * @author Administrator
 *
 */
public interface OrderDao {

	void add(Order order);

	Order find(String id);

	List<Order> getAll(boolean state);

	void update(Order order);

	List<Order> getAll(boolean state, String userid);

	List<Order> getAllOrder(String userid);

}