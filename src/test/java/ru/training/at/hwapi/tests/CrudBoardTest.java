package ru.training.at.hwapi.tests;

import io.restassured.http.Method;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;
import ru.training.at.hwapi.beans.TrelloBoard;
import ru.training.at.hwapi.constants.Endpoints;
import ru.training.at.hwapi.dataprovider.DataProviders;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static ru.training.at.hwapi.core.TrelloBoardServiceObj.*;

public class CrudBoardTest extends BaseTest {

    TrelloBoard newBoard;

    @Test(dataProviderClass = DataProviders.class,
            dataProvider = "boardName")
    public void createBoard(String boardName) {
        newBoard = createTestBoard(boardName);
        assertThat(newBoard.getName(), CoreMatchers.equalTo(boardName));
    }

    @Test(dependsOnMethods = "createBoard",
            dataProviderClass = DataProviders.class,
            dataProvider = "boardDescription")
    public void updateBoardDescription(String description) {
        TrelloBoard getBoard = getBoardInfo(
                requestBuilder()
                        .setMethod(Method.PUT)
                        .setDescr(description)
                        .buildRequest()
                        .sendRequest(Endpoints.BOARDS + newBoard.getId())
                        .then()
                        .assertThat()
                        .spec(goodResponseSpec())
                        .extract().response()
        );
        assertThat(description, equalTo(getBoard.getDesc()));
    }

    @Test(dependsOnMethods = "createBoard")
    public void getBoard() {
        TrelloBoard getBoard = getBoardInfo(
                requestBuilder()
                        .buildRequest()
                        .sendRequest(Endpoints.BOARDS + newBoard.getId())
                        .then()
                        .assertThat()
                        .spec(goodResponseSpec())
                        .extract().response()
        );
        assertThat(getBoard.getName(), equalTo(newBoard.getName()));
    }

    @Test(dependsOnMethods = "getBoard")
    public void deleteBoard() {
        deleteBoard(newBoard.getId());

        requestBuilder()
                .setMethod(Method.GET)
                .setBoardId(newBoard.getId())
                .buildRequest()
                .sendRequest(Endpoints.BOARDS + newBoard.getId())
                .then()
                .assertThat()
                .spec(notFoundResponseSpec())
                .extract().response();
    }
}
