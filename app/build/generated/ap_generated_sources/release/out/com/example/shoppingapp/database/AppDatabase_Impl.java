package com.example.shoppingapp.database;

import androidx.annotation.NonNull;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import com.example.shoppingapp.database.dao.CategoryDao;
import com.example.shoppingapp.database.dao.CategoryDao_Impl;
import com.example.shoppingapp.database.dao.FavoriteDao;
import com.example.shoppingapp.database.dao.FavoriteDao_Impl;
import com.example.shoppingapp.database.dao.OrderDao;
import com.example.shoppingapp.database.dao.OrderDao_Impl;
import com.example.shoppingapp.database.dao.OrderDetailDao;
import com.example.shoppingapp.database.dao.OrderDetailDao_Impl;
import com.example.shoppingapp.database.dao.ProductDao;
import com.example.shoppingapp.database.dao.ProductDao_Impl;
import com.example.shoppingapp.database.dao.ReviewDao;
import com.example.shoppingapp.database.dao.ReviewDao_Impl;
import com.example.shoppingapp.database.dao.UserDao;
import com.example.shoppingapp.database.dao.UserDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile UserDao _userDao;

  private volatile CategoryDao _categoryDao;

  private volatile ProductDao _productDao;

  private volatile OrderDao _orderDao;

  private volatile OrderDetailDao _orderDetailDao;

  private volatile FavoriteDao _favoriteDao;

  private volatile ReviewDao _reviewDao;

  @Override
  @NonNull
  protected RoomOpenDelegate createOpenDelegate() {
    final RoomOpenDelegate _openDelegate = new RoomOpenDelegate(11, "9ef3d576ba6e29debf48cb4dfa244625", "b1365d6d5973689f0cb60d9c6de9fc89") {
      @Override
      public void createAllTables(@NonNull final SQLiteConnection connection) {
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `users` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `username` TEXT, `password` TEXT, `fullName` TEXT, `phone` TEXT, `email` TEXT, `address` TEXT)");
        SQLite.execSQL(connection, "CREATE UNIQUE INDEX IF NOT EXISTS `index_users_username` ON `users` (`username`)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `categories` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `description` TEXT, `imageUrl` TEXT)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `products` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `brand` TEXT, `description` TEXT, `price` REAL NOT NULL, `originalPrice` REAL NOT NULL, `imageUrl` TEXT, `unit` TEXT, `categoryId` INTEGER NOT NULL, `sizes` TEXT, `rating` REAL NOT NULL, `reviewCount` INTEGER NOT NULL, `stockQuantity` INTEGER NOT NULL, FOREIGN KEY(`categoryId`) REFERENCES `categories`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_products_categoryId` ON `products` (`categoryId`)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `orders` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` INTEGER NOT NULL, `orderDate` TEXT, `totalAmount` REAL NOT NULL, `status` TEXT, `address` TEXT, `paymentMethod` TEXT, FOREIGN KEY(`userId`) REFERENCES `users`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_orders_userId` ON `orders` (`userId`)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `order_details` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `orderId` INTEGER NOT NULL, `productId` INTEGER NOT NULL, `quantity` INTEGER NOT NULL, `unitPrice` REAL NOT NULL, FOREIGN KEY(`orderId`) REFERENCES `orders`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`productId`) REFERENCES `products`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_order_details_orderId` ON `order_details` (`orderId`)");
        SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_order_details_productId` ON `order_details` (`productId`)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `favorites` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` INTEGER NOT NULL, `productId` INTEGER NOT NULL, FOREIGN KEY(`userId`) REFERENCES `users`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`productId`) REFERENCES `products`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_favorites_userId` ON `favorites` (`userId`)");
        SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_favorites_productId` ON `favorites` (`productId`)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `reviews` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` INTEGER NOT NULL, `productId` INTEGER NOT NULL, `rating` REAL NOT NULL, `comment` TEXT, `date` TEXT, `userName` TEXT, FOREIGN KEY(`userId`) REFERENCES `users`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`productId`) REFERENCES `products`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_reviews_userId` ON `reviews` (`userId`)");
        SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_reviews_productId` ON `reviews` (`productId`)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '9ef3d576ba6e29debf48cb4dfa244625')");
      }

      @Override
      public void dropAllTables(@NonNull final SQLiteConnection connection) {
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `users`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `categories`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `products`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `orders`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `order_details`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `favorites`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `reviews`");
      }

      @Override
      public void onCreate(@NonNull final SQLiteConnection connection) {
      }

      @Override
      public void onOpen(@NonNull final SQLiteConnection connection) {
        SQLite.execSQL(connection, "PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(connection);
      }

      @Override
      public void onPreMigrate(@NonNull final SQLiteConnection connection) {
        DBUtil.dropFtsSyncTriggers(connection);
      }

      @Override
      public void onPostMigrate(@NonNull final SQLiteConnection connection) {
      }

      @Override
      @NonNull
      public RoomOpenDelegate.ValidationResult onValidateSchema(
          @NonNull final SQLiteConnection connection) {
        final Map<String, TableInfo.Column> _columnsUsers = new HashMap<String, TableInfo.Column>(7);
        _columnsUsers.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("username", new TableInfo.Column("username", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("password", new TableInfo.Column("password", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("fullName", new TableInfo.Column("fullName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("phone", new TableInfo.Column("phone", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("email", new TableInfo.Column("email", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("address", new TableInfo.Column("address", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysUsers = new HashSet<TableInfo.ForeignKey>(0);
        final Set<TableInfo.Index> _indicesUsers = new HashSet<TableInfo.Index>(1);
        _indicesUsers.add(new TableInfo.Index("index_users_username", true, Arrays.asList("username"), Arrays.asList("ASC")));
        final TableInfo _infoUsers = new TableInfo("users", _columnsUsers, _foreignKeysUsers, _indicesUsers);
        final TableInfo _existingUsers = TableInfo.read(connection, "users");
        if (!_infoUsers.equals(_existingUsers)) {
          return new RoomOpenDelegate.ValidationResult(false, "users(com.example.shoppingapp.database.entity.User).\n"
                  + " Expected:\n" + _infoUsers + "\n"
                  + " Found:\n" + _existingUsers);
        }
        final Map<String, TableInfo.Column> _columnsCategories = new HashMap<String, TableInfo.Column>(4);
        _columnsCategories.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategories.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategories.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategories.put("imageUrl", new TableInfo.Column("imageUrl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysCategories = new HashSet<TableInfo.ForeignKey>(0);
        final Set<TableInfo.Index> _indicesCategories = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCategories = new TableInfo("categories", _columnsCategories, _foreignKeysCategories, _indicesCategories);
        final TableInfo _existingCategories = TableInfo.read(connection, "categories");
        if (!_infoCategories.equals(_existingCategories)) {
          return new RoomOpenDelegate.ValidationResult(false, "categories(com.example.shoppingapp.database.entity.Category).\n"
                  + " Expected:\n" + _infoCategories + "\n"
                  + " Found:\n" + _existingCategories);
        }
        final Map<String, TableInfo.Column> _columnsProducts = new HashMap<String, TableInfo.Column>(13);
        _columnsProducts.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProducts.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProducts.put("brand", new TableInfo.Column("brand", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProducts.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProducts.put("price", new TableInfo.Column("price", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProducts.put("originalPrice", new TableInfo.Column("originalPrice", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProducts.put("imageUrl", new TableInfo.Column("imageUrl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProducts.put("unit", new TableInfo.Column("unit", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProducts.put("categoryId", new TableInfo.Column("categoryId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProducts.put("sizes", new TableInfo.Column("sizes", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProducts.put("rating", new TableInfo.Column("rating", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProducts.put("reviewCount", new TableInfo.Column("reviewCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProducts.put("stockQuantity", new TableInfo.Column("stockQuantity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysProducts = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysProducts.add(new TableInfo.ForeignKey("categories", "CASCADE", "NO ACTION", Arrays.asList("categoryId"), Arrays.asList("id")));
        final Set<TableInfo.Index> _indicesProducts = new HashSet<TableInfo.Index>(1);
        _indicesProducts.add(new TableInfo.Index("index_products_categoryId", false, Arrays.asList("categoryId"), Arrays.asList("ASC")));
        final TableInfo _infoProducts = new TableInfo("products", _columnsProducts, _foreignKeysProducts, _indicesProducts);
        final TableInfo _existingProducts = TableInfo.read(connection, "products");
        if (!_infoProducts.equals(_existingProducts)) {
          return new RoomOpenDelegate.ValidationResult(false, "products(com.example.shoppingapp.database.entity.Product).\n"
                  + " Expected:\n" + _infoProducts + "\n"
                  + " Found:\n" + _existingProducts);
        }
        final Map<String, TableInfo.Column> _columnsOrders = new HashMap<String, TableInfo.Column>(7);
        _columnsOrders.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("userId", new TableInfo.Column("userId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("orderDate", new TableInfo.Column("orderDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("totalAmount", new TableInfo.Column("totalAmount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("status", new TableInfo.Column("status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("address", new TableInfo.Column("address", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("paymentMethod", new TableInfo.Column("paymentMethod", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysOrders = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysOrders.add(new TableInfo.ForeignKey("users", "CASCADE", "NO ACTION", Arrays.asList("userId"), Arrays.asList("id")));
        final Set<TableInfo.Index> _indicesOrders = new HashSet<TableInfo.Index>(1);
        _indicesOrders.add(new TableInfo.Index("index_orders_userId", false, Arrays.asList("userId"), Arrays.asList("ASC")));
        final TableInfo _infoOrders = new TableInfo("orders", _columnsOrders, _foreignKeysOrders, _indicesOrders);
        final TableInfo _existingOrders = TableInfo.read(connection, "orders");
        if (!_infoOrders.equals(_existingOrders)) {
          return new RoomOpenDelegate.ValidationResult(false, "orders(com.example.shoppingapp.database.entity.Order).\n"
                  + " Expected:\n" + _infoOrders + "\n"
                  + " Found:\n" + _existingOrders);
        }
        final Map<String, TableInfo.Column> _columnsOrderDetails = new HashMap<String, TableInfo.Column>(5);
        _columnsOrderDetails.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrderDetails.put("orderId", new TableInfo.Column("orderId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrderDetails.put("productId", new TableInfo.Column("productId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrderDetails.put("quantity", new TableInfo.Column("quantity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrderDetails.put("unitPrice", new TableInfo.Column("unitPrice", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysOrderDetails = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysOrderDetails.add(new TableInfo.ForeignKey("orders", "CASCADE", "NO ACTION", Arrays.asList("orderId"), Arrays.asList("id")));
        _foreignKeysOrderDetails.add(new TableInfo.ForeignKey("products", "CASCADE", "NO ACTION", Arrays.asList("productId"), Arrays.asList("id")));
        final Set<TableInfo.Index> _indicesOrderDetails = new HashSet<TableInfo.Index>(2);
        _indicesOrderDetails.add(new TableInfo.Index("index_order_details_orderId", false, Arrays.asList("orderId"), Arrays.asList("ASC")));
        _indicesOrderDetails.add(new TableInfo.Index("index_order_details_productId", false, Arrays.asList("productId"), Arrays.asList("ASC")));
        final TableInfo _infoOrderDetails = new TableInfo("order_details", _columnsOrderDetails, _foreignKeysOrderDetails, _indicesOrderDetails);
        final TableInfo _existingOrderDetails = TableInfo.read(connection, "order_details");
        if (!_infoOrderDetails.equals(_existingOrderDetails)) {
          return new RoomOpenDelegate.ValidationResult(false, "order_details(com.example.shoppingapp.database.entity.OrderDetail).\n"
                  + " Expected:\n" + _infoOrderDetails + "\n"
                  + " Found:\n" + _existingOrderDetails);
        }
        final Map<String, TableInfo.Column> _columnsFavorites = new HashMap<String, TableInfo.Column>(3);
        _columnsFavorites.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavorites.put("userId", new TableInfo.Column("userId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavorites.put("productId", new TableInfo.Column("productId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysFavorites = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysFavorites.add(new TableInfo.ForeignKey("users", "CASCADE", "NO ACTION", Arrays.asList("userId"), Arrays.asList("id")));
        _foreignKeysFavorites.add(new TableInfo.ForeignKey("products", "CASCADE", "NO ACTION", Arrays.asList("productId"), Arrays.asList("id")));
        final Set<TableInfo.Index> _indicesFavorites = new HashSet<TableInfo.Index>(2);
        _indicesFavorites.add(new TableInfo.Index("index_favorites_userId", false, Arrays.asList("userId"), Arrays.asList("ASC")));
        _indicesFavorites.add(new TableInfo.Index("index_favorites_productId", false, Arrays.asList("productId"), Arrays.asList("ASC")));
        final TableInfo _infoFavorites = new TableInfo("favorites", _columnsFavorites, _foreignKeysFavorites, _indicesFavorites);
        final TableInfo _existingFavorites = TableInfo.read(connection, "favorites");
        if (!_infoFavorites.equals(_existingFavorites)) {
          return new RoomOpenDelegate.ValidationResult(false, "favorites(com.example.shoppingapp.database.entity.Favorite).\n"
                  + " Expected:\n" + _infoFavorites + "\n"
                  + " Found:\n" + _existingFavorites);
        }
        final Map<String, TableInfo.Column> _columnsReviews = new HashMap<String, TableInfo.Column>(7);
        _columnsReviews.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReviews.put("userId", new TableInfo.Column("userId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReviews.put("productId", new TableInfo.Column("productId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReviews.put("rating", new TableInfo.Column("rating", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReviews.put("comment", new TableInfo.Column("comment", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReviews.put("date", new TableInfo.Column("date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReviews.put("userName", new TableInfo.Column("userName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysReviews = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysReviews.add(new TableInfo.ForeignKey("users", "CASCADE", "NO ACTION", Arrays.asList("userId"), Arrays.asList("id")));
        _foreignKeysReviews.add(new TableInfo.ForeignKey("products", "CASCADE", "NO ACTION", Arrays.asList("productId"), Arrays.asList("id")));
        final Set<TableInfo.Index> _indicesReviews = new HashSet<TableInfo.Index>(2);
        _indicesReviews.add(new TableInfo.Index("index_reviews_userId", false, Arrays.asList("userId"), Arrays.asList("ASC")));
        _indicesReviews.add(new TableInfo.Index("index_reviews_productId", false, Arrays.asList("productId"), Arrays.asList("ASC")));
        final TableInfo _infoReviews = new TableInfo("reviews", _columnsReviews, _foreignKeysReviews, _indicesReviews);
        final TableInfo _existingReviews = TableInfo.read(connection, "reviews");
        if (!_infoReviews.equals(_existingReviews)) {
          return new RoomOpenDelegate.ValidationResult(false, "reviews(com.example.shoppingapp.database.entity.Review).\n"
                  + " Expected:\n" + _infoReviews + "\n"
                  + " Found:\n" + _existingReviews);
        }
        return new RoomOpenDelegate.ValidationResult(true, null);
      }
    };
    return _openDelegate;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final Map<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final Map<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "users", "categories", "products", "orders", "order_details", "favorites", "reviews");
  }

  @Override
  public void clearAllTables() {
    super.performClear(true, "users", "categories", "products", "orders", "order_details", "favorites", "reviews");
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final Map<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CategoryDao.class, CategoryDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ProductDao.class, ProductDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(OrderDao.class, OrderDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(OrderDetailDao.class, OrderDetailDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(FavoriteDao.class, FavoriteDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ReviewDao.class, ReviewDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final Set<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public CategoryDao categoryDao() {
    if (_categoryDao != null) {
      return _categoryDao;
    } else {
      synchronized(this) {
        if(_categoryDao == null) {
          _categoryDao = new CategoryDao_Impl(this);
        }
        return _categoryDao;
      }
    }
  }

  @Override
  public ProductDao productDao() {
    if (_productDao != null) {
      return _productDao;
    } else {
      synchronized(this) {
        if(_productDao == null) {
          _productDao = new ProductDao_Impl(this);
        }
        return _productDao;
      }
    }
  }

  @Override
  public OrderDao orderDao() {
    if (_orderDao != null) {
      return _orderDao;
    } else {
      synchronized(this) {
        if(_orderDao == null) {
          _orderDao = new OrderDao_Impl(this);
        }
        return _orderDao;
      }
    }
  }

  @Override
  public OrderDetailDao orderDetailDao() {
    if (_orderDetailDao != null) {
      return _orderDetailDao;
    } else {
      synchronized(this) {
        if(_orderDetailDao == null) {
          _orderDetailDao = new OrderDetailDao_Impl(this);
        }
        return _orderDetailDao;
      }
    }
  }

  @Override
  public FavoriteDao favoriteDao() {
    if (_favoriteDao != null) {
      return _favoriteDao;
    } else {
      synchronized(this) {
        if(_favoriteDao == null) {
          _favoriteDao = new FavoriteDao_Impl(this);
        }
        return _favoriteDao;
      }
    }
  }

  @Override
  public ReviewDao reviewDao() {
    if (_reviewDao != null) {
      return _reviewDao;
    } else {
      synchronized(this) {
        if(_reviewDao == null) {
          _reviewDao = new ReviewDao_Impl(this);
        }
        return _reviewDao;
      }
    }
  }
}
