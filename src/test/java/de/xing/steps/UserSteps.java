package de.xing.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import de.xing.api.ReqresAPI;
import de.xing.model.UserDto;
import de.xing.model.UsersDto;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserSteps {
    final Logger LOGGER = LoggerFactory.getLogger(UserSteps.class);

    private Response response;
    private UsersDto users;
    private UserDto user;

    @When("^i request the user list$")
    public void i_request_the_user_list() throws MalformedURLException {
        response = get(ReqresAPI.users());
        users = response.getBody().as(UsersDto.class);
    }

    @When("^i request page (\\d+) of the user list$")
    public void i_request_page_x_of_the_user_list(int page) throws MalformedURLException {
        response = get(ReqresAPI.getUsersByPage(page));
        users = response.getBody().as(UsersDto.class);
    }

    @When("^i request the user with id (\\d+)$")
    public void i_reqest_the_user_with_id(int id) throws MalformedURLException {
        response = get(ReqresAPI.userWithID(id));
        user = response.getBody().as(UserDto.class);
    }

    @When("^i create a new user with first name '(.*)'$")
    public void i_create_a_new_user_with_first_name_x_and_last_name_y(String firstName) throws MalformedURLException {
        final String body = "{\"first_name\":\"" + firstName + "\"}";
        response = with().contentType("application/json").and().body(body).post(ReqresAPI.users());
    }

    @When("^i put a users first name to '(.*)'$")
    public void i_put_a_users_first_name_to(String firstName) throws MalformedURLException {
        final String body = "{\"first_name\":\"" + firstName + "\"}";
        response = with().contentType("application/json").and().body(body).put(ReqresAPI.userWithID(1));
    }

    @When("^i patch a users first name to '(.*)'$")
    public void i_patch_a_users_first_name_to(String firstName) throws MalformedURLException {
        final String body = "{\"first_name\":\"" + firstName + "\"}";
        response = with().contentType("application/json").and().body(body).patch(ReqresAPI.userWithID(1));
    }

    @When("^i delete the user with id (\\d+)$")
    public void i_delete_the_user_with_id_x(int id) throws MalformedURLException {
        response = delete(ReqresAPI.userWithID(id));
    }

    @Then("^i expect to get page (\\d+) of the user list$")
    public void i_expect_to_get_page_x_of_the_user_list(int page) {
        assertThat(users.getPage(), is(page));
    }

    @Then("^i expect that the total number of pages is (\\d+)$")
    public void i_expect_that_the_total_number_of_pages_is_x(int totalPages) {
        assertThat(users.getTotal_pages(), is(totalPages));
    }

    @Then("^i expect the list to contain (\\d+) users$")
    public void i_expect_the_list_to_contain_x_users(int number) {
        assertThat(users.getData().size(), is(number));
    }

    @Then("^i expect the users first name is '(.*)'$")
    public void i_expect_the_users_first_name_is_x(String firstName) {
        assertThat(user.getData().getFirst_name(), is(firstName));
    }

    @Then("^i expect the users last name is '(.*)'$")
    public void i_expect_the_users_last_name_is_x(String lastName) {
        assertThat(user.getData().getLast_name(), is(lastName));
    }

    @Then("^i expect the users avatar url is '(.*)'$")
    public void i_expect_the_users_avatar_url_is_x(String avatar) {
        assertThat(user.getData().getAvatar(), is(avatar));
    }

    @Then("^i expect to get a http (\\d+) status code$")
    public void i_expect_to_get_a_http_x_error_code(int statusCode) {
        assertThat(response.getStatusCode(), is(statusCode));
    }
}