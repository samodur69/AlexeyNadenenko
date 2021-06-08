package ru.training.at.hwapi;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.testng.annotations.BeforeSuite;
import ru.training.at.hwapi.beans.TrelloBoard;
import ru.training.at.hwapi.constants.Endpoints;

import static ru.training.at.hwapi.core.TrelloBoardServiceObj.*;

public class BaseTest {

    @BeforeSuite
    public void setUp() {
        RestAssured.baseURI = Endpoints.BASE_URI;
    }

    public TrelloBoard createTestBoard(String boardName) {
        TrelloBoard board = getBoardInfo(
                requestBuilder()
                        .setName(boardName)
                        .setMethod(Method.POST)
                        .buildRequest()
                        .sendRequest(Endpoints.BOARDS)
                        .then()
                        .assertThat()
                        .spec(goodResponseSpec())
                        .extract().response()
        );
        return board;
    }
}
