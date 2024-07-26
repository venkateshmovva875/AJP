<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.socialnetworking.*" %>
<%@ page import="java.util.List" %> 
<!DOCTYPE html>
<html>
<head>
    <title>Social Networking Website Attributes</title>
    <style type="text/css">
        /* Your CSS styles go here */
        body {
            margin: 0;
            padding: 0;
            background-color: #f0f2f5; /* Set your background color */
            font-size: 16px; /* Set the font size to 16px */
            font-family: Arial, sans-serif; /* Use a common sans-serif font */
        }

        h1 {
            font-size: 30px; /* Increase the font size */
            font-weight: bold;
            margin-bottom: 10px;
            color: #1877f2; /* Facebook-like blue */
        }

        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }

        li {
            color: #333333; /* Dark text color */
            margin-bottom: 10px;
        }

        .frame-container {
            display: flex;
            justify-content: space-between;
            width: 100%;
            height: 100vh; /* Make the container cover the full viewport height */
            padding: 20px;
            box-sizing: border-box;
        }

        .frame {
            border: 1px solid #ccc;
            padding: 20px;
            margin: 0; /* Remove margin to eliminate space at the bottom */
            background-color: #fff;
            transition: background-color 0.3s ease;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .left-frame {
            flex: 1;
            background-color: #1877f2; /* Blue background for left container */
            color: #ffffff; /* White font color */
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 20px;
        }

        .center-frame {
            flex: 2;
        }

        .right-frame {
            flex: 1;
            background-color: #1877f2; /* Blue background for right container */
            color: #ffffff; /* White font color */
        }

        /* Styling for buttons */
        .button {
            display: inline-block;
            padding: 10px 20px;
            background-color: #166fe5; /* Slightly darker blue */
            color: #ffffff; /* White text color */
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            margin: 10px 0;
        }

        .button:hover {
            background-color: #1357c4; /* Darker blue on hover */
        }

        /* Logout button styling */
        .logout-button {
            background-color: #ff4444; /* Red color for logout button */
            color: #ffffff; /* White font color */
        }

        .logout-button:hover {
            background-color: #cc0000; /* Darker red on hover */
        }

        .scrollable-container {
            max-height: 500px; /* Increase the maximum height for the container */
            overflow-y: auto; /* Enable vertical scrolling if content overflows */
        }
    </style>
</head>
<body>
<%
    String usernameString = session.getAttribute("username").toString();
    // Display user info in the left frame
%>
<div class="frame-container">
    <div class="frame left-frame">
        <div class="user-info-container">
            <h2>About Me</h2>
            <p>This is where your bio information will be displayed.</p>
            <p>Myself <%= usernameString %> and my age is 19. Currently, I am studying in the 3rd year of CSE at Vignan University, Vadlamudu, Guntur.</p>
        </div>
        <!-- Center-align buttons -->
        <div style="text-align: center;">
            <a href="create_post.jsp" class="button">Create a Post</a>
            <a href="addComment.jsp" class="button">Add a Comment</a>
            <a href="logout.jsp" class="button logout-button">Logout</a>
        </div>
    </div>

    <div class="frame center-frame">
        <h2>Posts</h2>
        <div class="scrollable-container">
            <%
                PostsDao d = new PostsDao();
                List<Post> posts = d.getPostsFromDatabase();
                for (Post post : posts) {
            %>
            <div class="post">
                <h3><%= post.getTitle() %></h3>
                <p><%= post.getContent() %></p>
            </div>
            <%
                }
            %>
        </div>
    </div>

    <div class="frame right-frame">
        <h2>Comments</h2>
        <div class="scrollable-container">
            <%
                CommentsDao c = new CommentsDao();
                List<String> comments = c.getCommentsFromDatabase();
                for (String comment : comments) {
            %>
            <div class="comment">
                <p><%= comment %></p>
            </div>
            <%
                }
            %>
        </div>
    </div>
</div>
</body>
</html>
