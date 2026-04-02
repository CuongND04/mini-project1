package com.example.shoppingapp.database.dao;

import androidx.annotation.NonNull;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import com.example.shoppingapp.database.entity.OrderDetail;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class OrderDetailDao_Impl implements OrderDetailDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<OrderDetail> __insertAdapterOfOrderDetail;

  public OrderDetailDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfOrderDetail = new EntityInsertAdapter<OrderDetail>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `order_details` (`id`,`orderId`,`productId`,`quantity`,`unitPrice`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement, final OrderDetail entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getOrderId());
        statement.bindLong(3, entity.getProductId());
        statement.bindLong(4, entity.getQuantity());
        statement.bindDouble(5, entity.getUnitPrice());
      }
    };
  }

  @Override
  public void insert(final OrderDetail orderDetail) {
    DBUtil.performBlocking(__db, false, true, (_connection) -> {
      __insertAdapterOfOrderDetail.insert(_connection, orderDetail);
      return null;
    });
  }

  @Override
  public List<OrderDetail> getOrderDetailsByOrderId(final int orderId) {
    final String _sql = "SELECT * FROM order_details WHERE orderId = ?";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, orderId);
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfOrderId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "orderId");
        final int _columnIndexOfProductId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "productId");
        final int _columnIndexOfQuantity = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "quantity");
        final int _columnIndexOfUnitPrice = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "unitPrice");
        final List<OrderDetail> _result = new ArrayList<OrderDetail>();
        while (_stmt.step()) {
          final OrderDetail _item;
          final int _tmpOrderId;
          _tmpOrderId = (int) (_stmt.getLong(_columnIndexOfOrderId));
          final int _tmpProductId;
          _tmpProductId = (int) (_stmt.getLong(_columnIndexOfProductId));
          final int _tmpQuantity;
          _tmpQuantity = (int) (_stmt.getLong(_columnIndexOfQuantity));
          final double _tmpUnitPrice;
          _tmpUnitPrice = _stmt.getDouble(_columnIndexOfUnitPrice);
          _item = new OrderDetail(_tmpOrderId,_tmpProductId,_tmpQuantity,_tmpUnitPrice);
          final int _tmpId;
          _tmpId = (int) (_stmt.getLong(_columnIndexOfId));
          _item.setId(_tmpId);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public double getTotalByOrderId(final int orderId) {
    final String _sql = "SELECT SUM(quantity * unitPrice) FROM order_details WHERE orderId = ?";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, orderId);
        final double _result;
        if (_stmt.step()) {
          _result = _stmt.getDouble(0);
        } else {
          _result = 0.0;
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public OrderDetail getOrderDetail(final int orderId, final int productId) {
    final String _sql = "SELECT * FROM order_details WHERE orderId = ? AND productId = ? LIMIT 1";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, orderId);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, productId);
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfOrderId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "orderId");
        final int _columnIndexOfProductId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "productId");
        final int _columnIndexOfQuantity = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "quantity");
        final int _columnIndexOfUnitPrice = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "unitPrice");
        final OrderDetail _result;
        if (_stmt.step()) {
          final int _tmpOrderId;
          _tmpOrderId = (int) (_stmt.getLong(_columnIndexOfOrderId));
          final int _tmpProductId;
          _tmpProductId = (int) (_stmt.getLong(_columnIndexOfProductId));
          final int _tmpQuantity;
          _tmpQuantity = (int) (_stmt.getLong(_columnIndexOfQuantity));
          final double _tmpUnitPrice;
          _tmpUnitPrice = _stmt.getDouble(_columnIndexOfUnitPrice);
          _result = new OrderDetail(_tmpOrderId,_tmpProductId,_tmpQuantity,_tmpUnitPrice);
          final int _tmpId;
          _tmpId = (int) (_stmt.getLong(_columnIndexOfId));
          _result.setId(_tmpId);
        } else {
          _result = null;
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public int getItemCount(final int orderId) {
    final String _sql = "SELECT COUNT(*) FROM order_details WHERE orderId = ?";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, orderId);
        final int _result;
        if (_stmt.step()) {
          _result = (int) (_stmt.getLong(0));
        } else {
          _result = 0;
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public void updateQuantity(final int id, final int quantity) {
    final String _sql = "UPDATE order_details SET quantity = quantity + ? WHERE id = ?";
    DBUtil.performBlocking(__db, false, true, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, quantity);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, id);
        _stmt.step();
        return null;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public void setQuantity(final int id, final int quantity) {
    final String _sql = "UPDATE order_details SET quantity = ? WHERE id = ?";
    DBUtil.performBlocking(__db, false, true, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, quantity);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, id);
        _stmt.step();
        return null;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public void deleteById(final int id) {
    final String _sql = "DELETE FROM order_details WHERE id = ?";
    DBUtil.performBlocking(__db, false, true, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        _stmt.step();
        return null;
      } finally {
        _stmt.close();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
