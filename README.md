# E-Commerce Product Management System – REST API

## 🚀 Project Overview
This is a **RESTful E-Commerce Backend API** built using **Spring Boot (3-Tier MVC Architecture)**, Hibernate, and MySQL.  
The system allows management of **products, carts, wishlists, orders, ratings, reviews, and product image metadata**.

**Key Features:**
- Product CRUD with soft delete
- Product search by name, category, and price range
- Product stock management
- Ratings and reviews for products
- Wishlist management
- Cart management
- Order placement and status update
- Product image metadata management (no file upload, only metadata)

---

## 🛠️ Tech Stack
- **Backend:** Java, Spring Boot, Hibernate
- **Database:** MySQL
- **API Testing:** Postman
- **Version Control:** Git & GitHub

---

## 📁 Database Design

**Tables:**
- `products`
- `product_images`
- `product_reviews`
- `wishlists`
- `carts`
- `cart_items`
- `orders`
- `order_items`

**Relationships:**
- One Product → Many Reviews
- One Product → Many Images
- One Cart → Many Cart Items
- One Order → Many Order Items

---

## ✅ Business Rules
- Product price must be > 0
- Product name must be unique per category
- Soft delete (`isActive = false`) for products
- Stock cannot be negative; availability auto updates
- Rating must be between 1 and 5
- One review per customer per product
- Cart item quantity ≥ 1
- Invalid order status transitions prevented (PENDING → SHIPPED → DELIVERED)
- Delivered orders cannot be updated

---

## 🧪 Postman Collection
All APIs have been **tested using Postman**. You can import the collection here:

https://kharodeshivani-8323784.postman.co/workspace/SpringBoot_Project1~3b2b7200-f6a9-4c4b-951a-783e6c8ead4f/collection/50745397-9ab6dfc0-6235-4be6-9b13-813e2761efc8?action=share&source=copy-link&creator=50745397


## ⚡ How to Run
1. Clone the repository:
```bash
git clone https://github.com/shivani-kharode/E-Commerce-Product-Management-System.git
