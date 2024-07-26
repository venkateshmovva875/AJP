<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="com.example.Book" %>
<%@ page import="com.example.FactoryProvider" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Books</title>
    <style>
        /* Add your CSS styles here */
        body {
            font-family: Arial, sans-serif;
            background-image:url("https://c4.wallpaperflare.com/wallpaper/285/640/905/library-books-interior-monastery-wallpaper-preview.jpg");
            background-repeat: no-repeat;
            background-attachment: fixed; 
            background-size: 100% 100%;
        }
        h1 {
            color: white;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color:white;

        }
        th, td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: orange;
        }
        .container {
            text-align: left;
            margin-top: 20px;
        }
        .btn {
            background-color: orange;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            text-decoration: none;
        }
        .btn:hover {
            background-color: #FF8C00;
        }
        form {
            color: white;
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>Search Books</h1>
    <div class="container">
        <a href="index.jsp" class="btn">Home</a>
    </div>
    <form action="searchBook.jsp" method="get">
        <label for="keyword">Search Book:</label>
        <input type="text" name="keyword" />
        <input type="submit" value="Search" />
    </form>

    <% 
        String keyword = request.getParameter("keyword");
        
        if (keyword != null && !keyword.isEmpty()) {
            Session searchSession = FactoryProvider.getFactory().openSession();
            try {
                searchSession.beginTransaction();
                List<Book> books = searchSession.createQuery("from Book where title like :keyword " +
                                                              "or author like :keyword " +
                                                              "or isbn like :keyword " +
                                                              "or id like :keyword " +
                                                              "or genre like :keyword " +
                                                              "or numCopies like :keyword")
                                            .setParameter("keyword", "%" + keyword + "%")
                                            .getResultList();
                searchSession.getTransaction().commit();
                
                if (!books.isEmpty()) {
    %>
                    <table>
                        <tr>
                            <th>Id</th>
                            <th>Title</th>
                            <th>Author</th>
                            <th>ISBN</th>
                            <th>Genre</th>
                            <th>Copies Available</th>
                        </tr>
                        
                        <% for (Book book : books) { %>
                            <tr>
                                <td><%= book.getId() %></td>
                                <td><%= book.getTitle() %></td>
                                <td><%= book.getAuthor() %></td>
                                <td><%= book.getIsbn() %></td>
                                <td><%= book.getGenre() %></td>
                                <td><%= book.getNumCopies() %></td>
                            </tr>
                        <% } %>
                    </table>
    <%          } else { %>
                    <p>No books found matching the search criteria.</p>
    <%          }
            } finally {
                if (searchSession != null && searchSession.isOpen()) {
                    searchSession.close();
                }
            }
        }
    %>
</body>
</html>

