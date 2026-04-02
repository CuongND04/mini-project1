package com.example.shoppingapp.database.dao;

import androidx.annotation.NonNull;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import com.example.shoppingapp.database.entity.Favorite;
import com.example.shoppingapp.database.entity.Product;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class FavoriteDao_Impl implements FavoriteDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<Favorite> __insertAdapterOfFavorite;

  public FavoriteDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfFavorite = new EntityInsertAdapter<Favorite>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `favorites` (`id`,`userId`,`productId`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement, final Favorite entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getUserId());
        statement.bindLong(3, entity.getProductId());
      }
    };
  }

  @Override
  public void insert(final Favorite favorite) {
    DBUtil.performBlocking(__db, false, true, (_connection) -> {
      __insertAdapterOfFavorite.insert(_connection, favorite);
      return null;
    });
  }

  @Override
  public boolean isFavorite(final int userId, final int productId) {
    final String _sql = "SELECT EXISTS(SELECT 1 FROM favorites WHERE userId = ? AND productId = ?)";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, userId);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, productId);
        final boolean _result;
        if (_stmt.step()) {
          final int _tmp;
          _tmp = (int) (_stmt.getLong(0));
          _result = _tmp != 0;
        } else {
          _result = false;
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public List<Product> getFavoriteProducts(final int userId) {
    final String _sql = "SELECT p.* FROM products p INNER JOIN favorites f ON p.id = f.productId WHERE f.userId = ?";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, userId);
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "name");
        final int _columnIndexOfBrand = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "brand");
        final int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "description");
        final int _columnIndexOfPrice = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "price");
        final int _columnIndexOfOriginalPrice = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "originalPrice");
        final int _columnIndexOfImageUrl = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "imageUrl");
        final int _columnIndexOfUnit = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "unit");
        final int _columnIndexOfCategoryId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "categoryId");
        final int _columnIndexOfSizes = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "sizes");
        final int _columnIndexOfRating = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "rating");
        final int _columnIndexOfReviewCount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "reviewCount");
        final int _columnIndexOfStockQuantity = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "stockQuantity");
        final List<Product> _result = new ArrayList<Product>();
        while (_stmt.step()) {
          final Product _item;
          final String _tmpName;
          if (_stmt.isNull(_columnIndexOfName)) {
            _tmpName = null;
          } else {
            _tmpName = _stmt.getText(_columnIndexOfName);
          }
          final String _tmpBrand;
          if (_stmt.isNull(_columnIndexOfBrand)) {
            _tmpBrand = null;
          } else {
            _tmpBrand = _stmt.getText(_columnIndexOfBrand);
          }
          final String _tmpDescription;
          if (_stmt.isNull(_columnIndexOfDescription)) {
            _tmpDescription = null;
          } else {
            _tmpDescription = _stmt.getText(_columnIndexOfDescription);
          }
          final double _tmpPrice;
          _tmpPrice = _stmt.getDouble(_columnIndexOfPrice);
          final String _tmpImageUrl;
          if (_stmt.isNull(_columnIndexOfImageUrl)) {
            _tmpImageUrl = null;
          } else {
            _tmpImageUrl = _stmt.getText(_columnIndexOfImageUrl);
          }
          final String _tmpUnit;
          if (_stmt.isNull(_columnIndexOfUnit)) {
            _tmpUnit = null;
          } else {
            _tmpUnit = _stmt.getText(_columnIndexOfUnit);
          }
          final int _tmpCategoryId;
          _tmpCategoryId = (int) (_stmt.getLong(_columnIndexOfCategoryId));
          _item = new Product(_tmpName,_tmpBrand,_tmpDescription,_tmpPrice,_tmpImageUrl,_tmpUnit,_tmpCategoryId);
          final int _tmpId;
          _tmpId = (int) (_stmt.getLong(_columnIndexOfId));
          _item.setId(_tmpId);
          final double _tmpOriginalPrice;
          _tmpOriginalPrice = _stmt.getDouble(_columnIndexOfOriginalPrice);
          _item.setOriginalPrice(_tmpOriginalPrice);
          final String _tmpSizes;
          if (_stmt.isNull(_columnIndexOfSizes)) {
            _tmpSizes = null;
          } else {
            _tmpSizes = _stmt.getText(_columnIndexOfSizes);
          }
          _item.setSizes(_tmpSizes);
          final float _tmpRating;
          _tmpRating = (float) (_stmt.getDouble(_columnIndexOfRating));
          _item.setRating(_tmpRating);
          final int _tmpReviewCount;
          _tmpReviewCount = (int) (_stmt.getLong(_columnIndexOfReviewCount));
          _item.setReviewCount(_tmpReviewCount);
          final int _tmpStockQuantity;
          _tmpStockQuantity = (int) (_stmt.getLong(_columnIndexOfStockQuantity));
          _item.setStockQuantity(_tmpStockQuantity);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public List<Integer> getFavoriteProductIds(final int userId) {
    final String _sql = "SELECT productId FROM favorites WHERE userId = ?";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, userId);
        final List<Integer> _result = new ArrayList<Integer>();
        while (_stmt.step()) {
          final Integer _item;
          if (_stmt.isNull(0)) {
            _item = null;
          } else {
            _item = (int) (_stmt.getLong(0));
          }
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public int getFavoriteCount(final int userId) {
    final String _sql = "SELECT COUNT(*) FROM favorites WHERE userId = ?";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, userId);
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
  public void delete(final int userId, final int productId) {
    final String _sql = "DELETE FROM favorites WHERE userId = ? AND productId = ?";
    DBUtil.performBlocking(__db, false, true, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, userId);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, productId);
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
