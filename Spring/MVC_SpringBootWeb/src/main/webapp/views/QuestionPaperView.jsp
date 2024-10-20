<%@page language="java" %>
<html>
    <body>
        <h2> Welcome Add Question</h2>
        <form action="addQue">
            <label for="id"> Enter Question id : </label>
            <input type="text" id="id" name="id"> <br>
            <label for="Question"> Enter Question Statement : </label>
            <input type="text" id="question" name="question"> <br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>