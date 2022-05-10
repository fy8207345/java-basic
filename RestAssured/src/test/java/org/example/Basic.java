package org.example;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import lombok.extern.slf4j.Slf4j;
import org.example.controller.TestController;
import org.example.vo.Greeting;
import org.example.vo.LettoVo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@Slf4j
@RunWith(SpringRunner.class)
@WebMvcTest(TestController.class)
public class Basic {

        @MockBean
        private TestController testController;
        @Spy
        private TestController spy;
        private AutoCloseable autoCloseable;

        @Before
        public void init(){
                autoCloseable = MockitoAnnotations.openMocks(this);
        }

        @After
        public void destory() throws Exception {
                autoCloseable.close();
        }

        @Test
        public void mockito() {
                log.info("spy: {}", spy.format("hhh"));
                Mockito.when(testController.greeting("snowdon"))
                                .thenReturn(Greeting.builder()
                                        .id(1)
                                        .name("hello !!!").build());
                log.info("result: {}", testController.greeting("snowdon"));
        }

        @Test
        public void restAssured() {
                Mockito.when(testController.greeting("snowdon"))
                        .thenReturn(Greeting.builder()
                                .id(1)
                                .name(String.format("test!!%s", "snowdon")).build());
                RestAssuredMockMvc.given()
                        .standaloneSetup(testController)
                        .param("name", "snowdon")
                        .accept("application/json")
                        .log()
                        .all()
                        .when()
                        .get("/greeting")
                        .then()
                        .log()
                        .all(true)
                        .statusCode(200)
                        .body("id", equalTo(1))
                        .body("name", equalTo("test!!snowdon"));

        }
}
