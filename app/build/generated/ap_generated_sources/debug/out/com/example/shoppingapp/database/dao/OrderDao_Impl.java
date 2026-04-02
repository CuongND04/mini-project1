package com.example.shoppingapp.database.dao;

import androidx.annotation.NonNull;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import com.example.shoppingapp.database.entity.Order;
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
public final class OrderDao_Impl implements OrderDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<Order> __insertAdapterOfOrder;

  private final EntityDeleteOrUpdateAdapter<Order> __updateAdapterOfOrder;

  public OrderDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfOrder = new EntityInsertAdapter<Order>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `orders` (`id`,`userId`,`orderDate`,`totalAmount`,`status`,`address`,`paymentMethod`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement, final Order entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getUserId());
        if (entity.getOrderDate() == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.getOrderDate());
        }
        statement.bindDouble(4, entity.getTotalAmount());
        if (entity.getStatus() == null) {
          statement.bindNull(5);
        } else {
          statement.bindText(5, entity.getStatus());
        }
        if (entity.getAddress() == null) {
          statement.bindNull(6);
        } else {
          statement.bindText(6, entity.getAddress());
        }
        if (entity.getPaymentMethod() == null) {
          statement.bindNull(7);
        } else {
          statement.bindText(7, entity.getPaymentMethod());
        }
      }
    };
    this.__updateAdapterOfOrder = new EntityDeleteOrUpdateAdapter<Order>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `orders` SET `id` = ?,`userId` = ?,`orderDate` = ?,`totalAmount` = ?,`status` = ?,`address` = ?,`paymentMethod` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement, final Order entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getUserId());
        if (entity.getOrderDate() == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.getOrderDate());
        }
        statement.bindDouble(4, entity.getTotalAmount());
        if (entity.getStatus() == null) {
          statement.bindNull(5);
        } else {
          statement.bindText(5, entity.getStatus());
        }
        if (entity.getAddress() == null) {
          statement.bindNull(6);
        } else {
          statement.bindText(6, entity.getAddress());
        }
        if (entity.getPaymentMethod() == null) {
          statement.bindNull(7);
        } else {
          statement.bindText(7, entity.getPaymentMethod());
        }
        statement.bindLong(8, entity.getId());
      }
    };
  }

  @Override
  public long insert(final Order order) {
    return DBUtil.performBlocking(__db, false, true, (_connection) -> {
      return __insertAdapterOfOrder.insertAndReturnId(_connection, order);
    });
  }

  @Override
  public void update(final Order order) {
    DBUtil.performBlocking(__db, false, true, (_connection) -> {
      __updateAdapterOfOrder.handle(_connection, order);
      return null;
    });
  }

  @Override
  public Order getPendingOrder(final int userId) {
    final String _sql = "SELECT * FROM orders WHERE userId = ? AND status = 'Pending' LIMIT 1";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, userId);
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfUserId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "userId");
        final int _columnIndexOfOrderDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "orderDate");
        final int _columnIndexOfTotalAmount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "totalAmount");
        final int _columnIndexOfStatus = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "status");
        final int _columnIndexOfAddress = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "address");
        final int _columnIndexOfPaymentMethod = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "paymentMethod");
        final Order _result;
        if (_stmt.step()) {
          final int _tmpUserId;
          _tmpUserId = (int) (_stmt.getLong(_columnIndexOfUserId));
          final String _tmpOrderDate;
          if (_stmt.isNull(_columnIndexOfOrderDate)) {
            _tmpOrderDate = null;
          } else {
            _tmpOrderDate = _stmt.getText(_columnIndexOfOrderDate);
          }
          final double _tmpTotalAmount;
          _tmpTotalAmount = _stmt.getDouble(_columnIndexOfTotalAmount);
          final String _tmpStatus;
          if (_stmt.isNull(_columnIndexOfStatus)) {
            _tmpStatus = null;
          } else {
            _tmpStatus = _stmt.getText(_columnIndexOfStatus);
          }
          _result = new Order(_tmpUserId,_tmpOrderDate,_tmpTotalAmount,_tmpStatus);
          final int _tmpId;
          _tmpId = (int) (_stmt.getLong(_columnIndexOfId));
          _result.setId(_tmpId);
          final String _tmpAddress;
          if (_stmt.isNull(_columnIndexOfAddress)) {
            _tmpAddress = null;
          } else {
            _tmpAddress = _stmt.getText(_columnIndexOfAddress);
          }
          _result.setAddress(_tmpAddress);
          final String _tmpPaymentMethod;
          if (_stmt.isNull(_columnIndexOfPaymentMethod)) {
            _tmpPaymentMethod = null;
          } else {
            _tmpPaymentMethod = _stmt.getText(_columnIndexOfPaymentMethod);
          }
          _result.setPaymentMethod(_tmpPaymentMethod);
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
  public Order getOrderById(final int id) {
    final String _sql = "SELECT * FROM orders WHERE id = ? LIMIT 1";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfUserId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "userId");
        final int _columnIndexOfOrderDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "orderDate");
        final int _columnIndexOfTotalAmount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "totalAmount");
        final int _columnIndexOfStatus = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "status");
        final int _columnIndexOfAddress = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "address");
        final int _columnIndexOfPaymentMethod = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "paymentMethod");
        final Order _result;
        if (_stmt.step()) {
          final int _tmpUserId;
          _tmpUserId = (int) (_stmt.getLong(_columnIndexOfUserId));
          final String _tmpOrderDate;
          if (_stmt.isNull(_columnIndexOfOrderDate)) {
            _tmpOrderDate = null;
          } else {
            _tmpOrderDate = _stmt.getText(_columnIndexOfOrderDate);
          }
          final double _tmpTotalAmount;
          _tmpTotalAmount = _stmt.getDouble(_columnIndexOfTotalAmount);
          final String _tmpStatus;
          if (_stmt.isNull(_columnIndexOfStatus)) {
            _tmpStatus = null;
          } else {
            _tmpStatus = _stmt.getText(_columnIndexOfStatus);
          }
          _result = new Order(_tmpUserId,_tmpOrderDate,_tmpTotalAmount,_tmpStatus);
          final int _tmpId;
          _tmpId = (int) (_stmt.getLong(_columnIndexOfId));
          _result.setId(_tmpId);
          final String _tmpAddress;
          if (_stmt.isNull(_columnIndexOfAddress)) {
            _tmpAddress = null;
          } else {
            _tmpAddress = _stmt.getText(_columnIndexOfAddress);
          }
          _result.setAddress(_tmpAddress);
          final String _tmpPaymentMethod;
          if (_stmt.isNull(_columnIndexOfPaymentMethod)) {
            _tmpPaymentMethod = null;
          } else {
            _tmpPaymentMethod = _stmt.getText(_columnIndexOfPaymentMethod);
          }
          _result.setPaymentMethod(_tmpPaymentMethod);
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
  public List<Order> getOrdersByUser(final int userId) {
    final String _sql = "SELECT * FROM orders WHERE userId = ?";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, userId);
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfUserId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "userId");
        final int _columnIndexOfOrderDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "orderDate");
        final int _columnIndexOfTotalAmount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "totalAmount");
        final int _columnIndexOfStatus = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "status");
        final int _columnIndexOfAddress = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "address");
        final int _columnIndexOfPaymentMethod = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "paymentMethod");
        final List<Order> _result = new ArrayList<Order>();
        while (_stmt.step()) {
          final Order _item;
          final int _tmpUserId;
          _tmpUserId = (int) (_stmt.getLong(_columnIndexOfUserId));
          final String _tmpOrderDate;
          if (_stmt.isNull(_columnIndexOfOrderDate)) {
            _tmpOrderDate = null;
          } else {
            _tmpOrderDate = _stmt.getText(_columnIndexOfOrderDate);
          }
          final double _tmpTotalAmount;
          _tmpTotalAmount = _stmt.getDouble(_columnIndexOfTotalAmount);
          final String _tmpStatus;
          if (_stmt.isNull(_columnIndexOfStatus)) {
            _tmpStatus = null;
          } else {
            _tmpStatus = _stmt.getText(_columnIndexOfStatus);
          }
          _item = new Order(_tmpUserId,_tmpOrderDate,_tmpTotalAmount,_tmpStatus);
          final int _tmpId;
          _tmpId = (int) (_stmt.getLong(_columnIndexOfId));
          _item.setId(_tmpId);
          final String _tmpAddress;
          if (_stmt.isNull(_columnIndexOfAddress)) {
            _tmpAddress = null;
          } else {
            _tmpAddress = _stmt.getText(_columnIndexOfAddress);
          }
          _item.setAddress(_tmpAddress);
          final String _tmpPaymentMethod;
          if (_stmt.isNull(_columnIndexOfPaymentMethod)) {
            _tmpPaymentMethod = null;
          } else {
            _tmpPaymentMethod = _stmt.getText(_columnIndexOfPaymentMethod);
          }
          _item.setPaymentMethod(_tmpPaymentMethod);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public List<Order> getPaidOrders(final int userId) {
    final String _sql = "SELECT * FROM orders WHERE userId = ? AND status = 'Paid' ORDER BY orderDate DESC";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, userId);
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfUserId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "userId");
        final int _columnIndexOfOrderDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "orderDate");
        final int _columnIndexOfTotalAmount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "totalAmount");
        final int _columnIndexOfStatus = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "status");
        final int _columnIndexOfAddress = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "address");
        final int _columnIndexOfPaymentMethod = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "paymentMethod");
        final List<Order> _result = new ArrayList<Order>();
        while (_stmt.step()) {
          final Order _item;
          final int _tmpUserId;
          _tmpUserId = (int) (_stmt.getLong(_columnIndexOfUserId));
          final String _tmpOrderDate;
          if (_stmt.isNull(_columnIndexOfOrderDate)) {
            _tmpOrderDate = null;
          } else {
            _tmpOrderDate = _stmt.getText(_columnIndexOfOrderDate);
          }
          final double _tmpTotalAmount;
          _tmpTotalAmount = _stmt.getDouble(_columnIndexOfTotalAmount);
          final String _tmpStatus;
          if (_stmt.isNull(_columnIndexOfStatus)) {
            _tmpStatus = null;
          } else {
            _tmpStatus = _stmt.getText(_columnIndexOfStatus);
          }
          _item = new Order(_tmpUserId,_tmpOrderDate,_tmpTotalAmount,_tmpStatus);
          final int _tmpId;
          _tmpId = (int) (_stmt.getLong(_columnIndexOfId));
          _item.setId(_tmpId);
          final String _tmpAddress;
          if (_stmt.isNull(_columnIndexOfAddress)) {
            _tmpAddress = null;
          } else {
            _tmpAddress = _stmt.getText(_columnIndexOfAddress);
          }
          _item.setAddress(_tmpAddress);
          final String _tmpPaymentMethod;
          if (_stmt.isNull(_columnIndexOfPaymentMethod)) {
            _tmpPaymentMethod = null;
          } else {
            _tmpPaymentMethod = _stmt.getText(_columnIndexOfPaymentMethod);
          }
          _item.setPaymentMethod(_tmpPaymentMethod);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public List<Order> getCompletedOrders(final int userId) {
    final String _sql = "SELECT * FROM orders WHERE userId = ? AND status NOT IN ('Pending', 'BuyNow') ORDER BY orderDate DESC";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, userId);
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfUserId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "userId");
        final int _columnIndexOfOrderDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "orderDate");
        final int _columnIndexOfTotalAmount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "totalAmount");
        final int _columnIndexOfStatus = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "status");
        final int _columnIndexOfAddress = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "address");
        final int _columnIndexOfPaymentMethod = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "paymentMethod");
        final List<Order> _result = new ArrayList<Order>();
        while (_stmt.step()) {
          final Order _item;
          final int _tmpUserId;
          _tmpUserId = (int) (_stmt.getLong(_columnIndexOfUserId));
          final String _tmpOrderDate;
          if (_stmt.isNull(_columnIndexOfOrderDate)) {
            _tmpOrderDate = null;
          } else {
            _tmpOrderDate = _stmt.getText(_columnIndexOfOrderDate);
          }
          final double _tmpTotalAmount;
          _tmpTotalAmount = _stmt.getDouble(_columnIndexOfTotalAmount);
          final String _tmpStatus;
          if (_stmt.isNull(_columnIndexOfStatus)) {
            _tmpStatus = null;
          } else {
            _tmpStatus = _stmt.getText(_columnIndexOfStatus);
          }
          _item = new Order(_tmpUserId,_tmpOrderDate,_tmpTotalAmount,_tmpStatus);
          final int _tmpId;
          _tmpId = (int) (_stmt.getLong(_columnIndexOfId));
          _item.setId(_tmpId);
          final String _tmpAddress;
          if (_stmt.isNull(_columnIndexOfAddress)) {
            _tmpAddress = null;
          } else {
            _tmpAddress = _stmt.getText(_columnIndexOfAddress);
          }
          _item.setAddress(_tmpAddress);
          final String _tmpPaymentMethod;
          if (_stmt.isNull(_columnIndexOfPaymentMethod)) {
            _tmpPaymentMethod = null;
          } else {
            _tmpPaymentMethod = _stmt.getText(_columnIndexOfPaymentMethod);
          }
          _item.setPaymentMethod(_tmpPaymentMethod);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public List<Order> getOrdersByStatus(final int userId, final String status) {
    final String _sql = "SELECT * FROM orders WHERE userId = ? AND status = ? ORDER BY orderDate DESC";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, userId);
        _argIndex = 2;
        if (status == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, status);
        }
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfUserId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "userId");
        final int _columnIndexOfOrderDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "orderDate");
        final int _columnIndexOfTotalAmount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "totalAmount");
        final int _columnIndexOfStatus = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "status");
        final int _columnIndexOfAddress = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "address");
        final int _columnIndexOfPaymentMethod = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "paymentMethod");
        final List<Order> _result = new ArrayList<Order>();
        while (_stmt.step()) {
          final Order _item;
          final int _tmpUserId;
          _tmpUserId = (int) (_stmt.getLong(_columnIndexOfUserId));
          final String _tmpOrderDate;
          if (_stmt.isNull(_columnIndexOfOrderDate)) {
            _tmpOrderDate = null;
          } else {
            _tmpOrderDate = _stmt.getText(_columnIndexOfOrderDate);
          }
          final double _tmpTotalAmount;
          _tmpTotalAmount = _stmt.getDouble(_columnIndexOfTotalAmount);
          final String _tmpStatus;
          if (_stmt.isNull(_columnIndexOfStatus)) {
            _tmpStatus = null;
          } else {
            _tmpStatus = _stmt.getText(_columnIndexOfStatus);
          }
          _item = new Order(_tmpUserId,_tmpOrderDate,_tmpTotalAmount,_tmpStatus);
          final int _tmpId;
          _tmpId = (int) (_stmt.getLong(_columnIndexOfId));
          _item.setId(_tmpId);
          final String _tmpAddress;
          if (_stmt.isNull(_columnIndexOfAddress)) {
            _tmpAddress = null;
          } else {
            _tmpAddress = _stmt.getText(_columnIndexOfAddress);
          }
          _item.setAddress(_tmpAddress);
          final String _tmpPaymentMethod;
          if (_stmt.isNull(_columnIndexOfPaymentMethod)) {
            _tmpPaymentMethod = null;
          } else {
            _tmpPaymentMethod = _stmt.getText(_columnIndexOfPaymentMethod);
          }
          _item.setPaymentMethod(_tmpPaymentMethod);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public void deleteById(final int id) {
    final String _sql = "DELETE FROM orders WHERE id = ?";
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
