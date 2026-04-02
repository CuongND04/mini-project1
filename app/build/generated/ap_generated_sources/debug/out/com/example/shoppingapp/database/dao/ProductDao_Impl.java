package com.example.shoppingapp.database.dao;

import androidx.annotation.NonNull;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import com.example.shoppingapp.database.entity.Product;
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
public final class ProductDao_Impl implements ProductDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<Product> __insertAdapterOfProduct;

  private final EntityDeleteOrUpdateAdapter<Product> __updateAdapterOfProduct;

  public ProductDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfProduct = new EntityInsertAdapter<Product>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `products` (`id`,`name`,`brand`,`description`,`price`,`originalPrice`,`imageUrl`,`unit`,`categoryId`,`sizes`,`rating`,`reviewCount`,`stockQuantity`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement, final Product entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getName());
        }
        if (entity.getBrand() == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.getBrand());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(4);
        } else {
          statement.bindText(4, entity.getDescription());
        }
        statement.bindDouble(5, entity.getPrice());
        statement.bindDouble(6, entity.getOriginalPrice());
        if (entity.getImageUrl() == null) {
          statement.bindNull(7);
        } else {
          statement.bindText(7, entity.getImageUrl());
        }
        if (entity.getUnit() == null) {
          statement.bindNull(8);
        } else {
          statement.bindText(8, entity.getUnit());
        }
        statement.bindLong(9, entity.getCategoryId());
        if (entity.getSizes() == null) {
          statement.bindNull(10);
        } else {
          statement.bindText(10, entity.getSizes());
        }
        statement.bindDouble(11, entity.getRating());
        statement.bindLong(12, entity.getReviewCount());
        statement.bindLong(13, entity.getStockQuantity());
      }
    };
    this.__updateAdapterOfProduct = new EntityDeleteOrUpdateAdapter<Product>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `products` SET `id` = ?,`name` = ?,`brand` = ?,`description` = ?,`price` = ?,`originalPrice` = ?,`imageUrl` = ?,`unit` = ?,`categoryId` = ?,`sizes` = ?,`rating` = ?,`reviewCount` = ?,`stockQuantity` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement, final Product entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getName());
        }
        if (entity.getBrand() == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.getBrand());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(4);
        } else {
          statement.bindText(4, entity.getDescription());
        }
        statement.bindDouble(5, entity.getPrice());
        statement.bindDouble(6, entity.getOriginalPrice());
        if (entity.getImageUrl() == null) {
          statement.bindNull(7);
        } else {
          statement.bindText(7, entity.getImageUrl());
        }
        if (entity.getUnit() == null) {
          statement.bindNull(8);
        } else {
          statement.bindText(8, entity.getUnit());
        }
        statement.bindLong(9, entity.getCategoryId());
        if (entity.getSizes() == null) {
          statement.bindNull(10);
        } else {
          statement.bindText(10, entity.getSizes());
        }
        statement.bindDouble(11, entity.getRating());
        statement.bindLong(12, entity.getReviewCount());
        statement.bindLong(13, entity.getStockQuantity());
        statement.bindLong(14, entity.getId());
      }
    };
  }

  @Override
  public void insert(final Product product) {
    DBUtil.performBlocking(__db, false, true, (_connection) -> {
      __insertAdapterOfProduct.insert(_connection, product);
      return null;
    });
  }

  @Override
  public void update(final Product product) {
    DBUtil.performBlocking(__db, false, true, (_connection) -> {
      __updateAdapterOfProduct.handle(_connection, product);
      return null;
    });
  }

  @Override
  public List<Product> getAllProducts() {
    final String _sql = "SELECT * FROM products";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
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
  public List<Product> getProductsByCategory(final int categoryId) {
    final String _sql = "SELECT * FROM products WHERE categoryId = ?";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, categoryId);
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
  public Product getProductById(final int id) {
    final String _sql = "SELECT * FROM products WHERE id = ? LIMIT 1";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
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
        final Product _result;
        if (_stmt.step()) {
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
          _result = new Product(_tmpName,_tmpBrand,_tmpDescription,_tmpPrice,_tmpImageUrl,_tmpUnit,_tmpCategoryId);
          final int _tmpId;
          _tmpId = (int) (_stmt.getLong(_columnIndexOfId));
          _result.setId(_tmpId);
          final double _tmpOriginalPrice;
          _tmpOriginalPrice = _stmt.getDouble(_columnIndexOfOriginalPrice);
          _result.setOriginalPrice(_tmpOriginalPrice);
          final String _tmpSizes;
          if (_stmt.isNull(_columnIndexOfSizes)) {
            _tmpSizes = null;
          } else {
            _tmpSizes = _stmt.getText(_columnIndexOfSizes);
          }
          _result.setSizes(_tmpSizes);
          final float _tmpRating;
          _tmpRating = (float) (_stmt.getDouble(_columnIndexOfRating));
          _result.setRating(_tmpRating);
          final int _tmpReviewCount;
          _tmpReviewCount = (int) (_stmt.getLong(_columnIndexOfReviewCount));
          _result.setReviewCount(_tmpReviewCount);
          final int _tmpStockQuantity;
          _tmpStockQuantity = (int) (_stmt.getLong(_columnIndexOfStockQuantity));
          _result.setStockQuantity(_tmpStockQuantity);
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
  public int getProductCount() {
    final String _sql = "SELECT COUNT(*) FROM products";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
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
  public List<Product> searchProducts(final String query) {
    final String _sql = "SELECT * FROM products WHERE name LIKE '%' || ? || '%' OR brand LIKE '%' || ? || '%' OR description LIKE '%' || ? || '%'";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (query == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, query);
        }
        _argIndex = 2;
        if (query == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, query);
        }
        _argIndex = 3;
        if (query == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, query);
        }
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
  public List<Product> searchProductsAdvanced(final String query) {
    final String _sql = "SELECT * FROM products WHERE name LIKE '%' || ? || '%' OR brand LIKE '%' || ? || '%' OR description LIKE '%' || ? || '%'";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (query == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, query);
        }
        _argIndex = 2;
        if (query == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, query);
        }
        _argIndex = 3;
        if (query == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, query);
        }
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
  public List<Product> getFeaturedProducts(final int limit) {
    final String _sql = "SELECT * FROM products LIMIT ?";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, limit);
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
  public List<Product> getRelatedProducts(final int categoryId, final int excludeId,
      final int limit) {
    final String _sql = "SELECT * FROM products WHERE categoryId = ? AND id != ? LIMIT ?";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, categoryId);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, excludeId);
        _argIndex = 3;
        _stmt.bindLong(_argIndex, limit);
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
  public void reduceStock(final int productId, final int quantity) {
    final String _sql = "UPDATE products SET stockQuantity = stockQuantity - ? WHERE id = ?";
    DBUtil.performBlocking(__db, false, true, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, quantity);
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
