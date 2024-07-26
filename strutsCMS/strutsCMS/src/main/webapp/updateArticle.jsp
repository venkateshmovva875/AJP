<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="com.example.Article" %>
<%@ page import="com.example.FactoryProvider" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Article</title>
    <style>
        /* Add your CSS styles here */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            
        }
        h1 {
            color: #333;
            text-align: center;
            padding: 20px 0;
            background-color: orange; /* Changed to orange */
            color: #fff;
            margin: 0;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        form {
            width: 50%;
            margin: 20px auto;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        button {
            padding: 10px;
            background-color: #4CAF50; /* Changed to green */
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover {
            background-color: #388E3C; /* Changed hover color */
        }
        .form-group input[type="submit"] {
            background-color: orange;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .form-group input[type="submit"]:hover {
            background-color: #FF8C00;
        }
    </style>
</head>
<body>
<h1>List of Articles</h1>
    
    <table>
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>content</th>
            <th>publicationDate</th>
            <th>authorInformation</th>
            <th>category</th>
        </tr>
        
        <% 
   
            Session session1 = FactoryProvider.getFactory().openSession();
            
            try {
                session1.beginTransaction();
                List<Article> articles = session1.createQuery("from Article").getResultList();
                
                for (Article i : articles) {
        %>
                <tr>
                    <td><%= i.getId() %></td>
                    <td><%= i.getTitle() %></td>
                    <td><%= i.getContent() %></td>
                    <td><%= i.getPublicationDate() %></td>
                    <td><%= i.getAuthorInformation() %></td>
                    <td><%= i.getCategory() %></td>
                </tr>
        <%
                }
                session1.getTransaction().commit();
            } finally {
                if (session1 != null && session1.isOpen()) {
                    session1.close();
                }
            }
        %>
    </table>
    <div class="container">
        <a href="index.jsp" class="btn">Home</a>
    </div>
    <h1>Update Article</h1>
    
    <form action="UpdateArticleAction" method="post">
    	<div class="form-group">
               <label for="id">id:</label>
               <input type="text" name="id" required />
           </div>
       	<div class="form-group">
               <label for="title">Title:</label>
               <input type="text" name="article.title" required />
           </div>
           <div class="form-group">
               <label for="Content">Content:</label>
               <input type="text" name="article.content" required />
           </div>
           <div class="form-group">
               <label for="PublicationDate">Publication Date:</label>
               <input type="date" name="article.publicationDate" required />
           </div>
           <div class="form-group">
               <label for="AuthorInformation">Author Information:</label>
               <input type="text" name="article.authorInformation" required />
           </div>
           <div class="form-group">
               <label for="Category">Category:</label>
               <input type="text" name="article.category" required />
           </div>
           <div class="form-group">
               <input type="submit" value="Update Article" />
           </div>
    </form>
    
    
    
</body>
</html>
