package com.example.shoppingapp.database.dao;

import androidx.annotation.NonNull;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import com.example.shoppingapp.database.entity.Review;
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
public final class ReviewDao_Impl implements ReviewDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<Review> __insertAdapterOfReview;

  public ReviewDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfReview = new EntityInsertAdapter<Review>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `reviews` (`id`,`userId`,`productId`,`rating`,`comment`,`date`,`userName`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement, final Review entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getUserId());
        statement.bindLong(3, entity.getProductId());
        statement.bindDouble(4, entity.getRating());
        if (entity.getComment() == null) {
          statement.bindNull(5);
        } else {
          statement.bindText(5, entity.getComment());
        }
        if (entity.getDate() == null) {
          statement.bindNull(6);
        } else {
          statement.bindText(6, entity.getDate());
        }
        if (entity.getUserName() == null) {
          statement.bindNull(7);
        } else {
          statement.bindText(7, entity.getUserName());
        }
      }
    };
  }

  @Override
  public void insert(final Review review) {
    DBUtil.performBlocking(__db, false, true, (_connection) -> {
      __insertAdapterOfReview.insert(_connection, review);
      return null;
    });
  }

  @Override
  public List<Review> getReviewsByProduct(final int productId) {
    final String _sql = "SELECT * FROM reviews WHERE productId = ? ORDER BY id DESC";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, productId);
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfUserId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "userId");
        final int _columnIndexOfProductId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "productId");
        final int _columnIndexOfRating = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "rating");
        final int _columnIndexOfComment = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "comment");
        final int _columnIndexOfDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "date");
        final int _columnIndexOfUserName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "userName");
        final List<Review> _result = new ArrayList<Review>();
        while (_stmt.step()) {
          final Review _item;
          final int _tmpUserId;
          _tmpUserId = (int) (_stmt.getLong(_columnIndexOfUserId));
          final int _tmpProductId;
          _tmpProductId = (int) (_stmt.getLong(_columnIndexOfProductId));
          final float _tmpRating;
          _tmpRating = (float) (_stmt.getDouble(_columnIndexOfRating));
          final String _tmpComment;
          if (_stmt.isNull(_columnIndexOfComment)) {
            _tmpComment = null;
          } else {
            _tmpComment = _stmt.getText(_columnIndexOfComment);
          }
          final String _tmpDate;
          if (_stmt.isNull(_columnIndexOfDate)) {
            _tmpDate = null;
          } else {
            _tmpDate = _stmt.getText(_columnIndexOfDate);
          }
          final String _tmpUserName;
          if (_stmt.isNull(_columnIndexOfUserName)) {
            _tmpUserName = null;
          } else {
            _tmpUserName = _stmt.getText(_columnIndexOfUserName);
          }
          _item = new Review(_tmpUserId,_tmpProductId,_tmpRating,_tmpComment,_tmpDate,_tmpUserName);
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
  public float getAverageRating(final int productId) {
    final String _sql = "SELECT AVG(rating) FROM reviews WHERE productId = ?";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, productId);
        final float _result;
        if (_stmt.step()) {
          _result = (float) (_stmt.getDouble(0));
        } else {
          _result = 0f;
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public int getReviewCount(final int productId) {
    final String _sql = "SELECT COUNT(*) FROM reviews WHERE productId = ?";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, productId);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
