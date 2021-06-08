package ru.training.at.hwapi;

import io.restassured.http.Method;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;
import ru.training.at.hwapi.beans.BoardList;
import ru.training.at.hwapi.beans.TrelloBoard;
import ru.training.at.hwapi.constants.Endpoints;
import ru.training.at.hwapi.dataprovider.DataProviders;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static ru.training.at.hwapi.core.TrelloBoardServiceObj.goodResponseSpec;
import static ru.training.at.hwapi.core.TrelloListServiceObj.*;

public class BoardListsTest extends BaseTest {

    TrelloBoard newBoard;
    BoardList newList;
    List<BoardList> boardLists;

    @Test(dataProviderClass = DataProviders.class,
            dataProvider = "boardName")
    public void createBoard(String boardName) {
        newBoard = createTestBoard(boardName);
        assertThat(newBoard.getName(), CoreMatchers.equalTo(boardName));
    }

    @Test(dependsOnMethods = "createBoard")
    public void getListOfLists() {
        boardLists = getListOfBoardLists(
                requestBuilder()
                        .setMethod(Method.GET)
                        .setBoardId(newBoard.getId())
                        .buildRequest()
                        .sendRequest(Endpoints.LISTS)
                        .then()
                        .assertThat()
                        .spec(goodResponseSpec())
                        .extract().response()
        );
        assertThat(boardLists.size(), equalTo(3));
    }

    @Test(dependsOnMethods = "getListOfLists",
            dataProviderClass = DataProviders.class,
            dataProvider = "listName")
    public void createListOnBoard(String listName) {
        newList = getListInfo(requestBuilder()
                .setMethod(Method.POST)
                .setBoardId(newBoard.getId())
                .setName(listName)
                .buildRequest()
                .sendRequest(Endpoints.LISTS)
                .then()
                .assertThat()
                .spec(goodResponseSpec())
                .extract().response()
        );
        assertThat(newList.getName(), equalTo(listName));
    }

    @Test
    public void deleteListOnBoard() {

    }
}
