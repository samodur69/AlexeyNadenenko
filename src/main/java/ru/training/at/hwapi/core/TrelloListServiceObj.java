package ru.training.at.hwapi.core;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import ru.training.at.hwapi.beans.BoardList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.lessThan;
import static ru.training.at.hwapi.constants.AuthKeys.KEY;
import static ru.training.at.hwapi.constants.AuthKeys.TOKEN;

public class TrelloListServiceObj {

    //Builder Pattern
    private final Method requestMethod;
    private final Map<String, String> parameters;
    private final Map<String, String> path;

    private TrelloListServiceObj(Map<String, String> parameters,
                                 Method method,
                                 Map<String, String> path) {
        this.parameters = parameters;
        this.path = path;
        this.requestMethod = method;
    }

    public static ApiRequestBuilder requestBuilder() {
        return new ApiRequestBuilder();
    }

    public static class ApiRequestBuilder {
        private Map<String, String> path = new HashMap<>();
        private Map<String, String> parameters = new HashMap<>();
        private Method requestMethod = Method.GET;

        public ApiRequestBuilder setMethod(Method method) {
            requestMethod = method;
            return this;
        }

        public ApiRequestBuilder setBoardId(String id) {
            path.put("id", id);
            return this;
        }

        //        public ApiRequestBuilder setListId(String id) {
        //            path.put("id", id);
        //            return this;
        //        }

        public ApiRequestBuilder setName(String name) {
            parameters.put("name", name);
            return this;
        }

        public TrelloListServiceObj buildRequest() {
            parameters.put("key", KEY);
            parameters.put("token", TOKEN);
            return new TrelloListServiceObj(parameters, requestMethod, path);
        }
    }

    public Response sendRequest(String pathUri) {
        return RestAssured
                .given(requestSpecification()).log().all()
                .basePath(pathUri)
                .pathParams(path)
                .queryParams(parameters)
                .request(requestMethod)
                .prettyPeek();
    }

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification goodResponseSpec() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectResponseTime(lessThan(10000L))
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }

    public static ResponseSpecification notFoundResponseSpec() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.TEXT)
                .expectResponseTime(lessThan(30000L))
                .expectStatusCode(HttpStatus.SC_NOT_FOUND)
                .build();
    }

    public static BoardList getListInfo(Response response) {
        return new Gson().fromJson(response.asString()
                                .trim(),
                        new TypeToken<BoardList>() {}.getType());
    }

    public static List<BoardList> getListOfBoardLists(Response response) {
        return new Gson()
                .fromJson(response.asString()
                                .trim(),
                        new TypeToken<List<BoardList>>() {
                        }.getType());
    }
}
