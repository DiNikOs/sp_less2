<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
    <head>
        <title>Home</title>
    </head>
    <body>
        <form:form>
            <form:label path="id">
                id
            </form:label>

            <form:label path="title">
                title
            </form:label>

            <form:label path="title">
                cost
            </form:label>
            <form:input path="id">
                <button type="submit">
                    Save
                </button>
            </form:input>
        </form:form>
    </body>
</html>