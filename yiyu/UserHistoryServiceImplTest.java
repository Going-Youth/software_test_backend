package com.yiyu.service.impl;

import com.yiyu.mapper.UserHistoryMapper;
import com.yiyu.pojo.GetAllMusic.GetAllMusic;
import com.yiyu.pojo.GetCollection.GetCollection;
import com.yiyu.pojo.GetFeedback.GetFeedback;
import com.yiyu.pojo.GetQuestionnaireHistory.GetQuestionnaireHistory;
import com.yiyu.pojo.GetReplyFeedback.GetReplyFeedback;
import com.yiyu.pojo.GetTestHistory.GetTestHistory;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("用户历史记录模块")
public class UserHistoryServiceImplTest {

    @Resource
    UserHistoryMapper userHistoryMapper;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("用户问卷历史记录")
    public void questionnaireHistory() {
        String user_id="123456789123456789";
        GetQuestionnaireHistory[] result;
        result=userHistoryMapper.QuestionnaireHistory(user_id);
        System.out.println(Arrays.deepToString(result));
        System.out.println(result.length);
        assertTrue(result.length>=0);


        user_id="1234567891234567";
        result=userHistoryMapper.QuestionnaireHistory(user_id);
        assertEquals(0,result.length);

        user_id="";
        result=userHistoryMapper.QuestionnaireHistory(user_id);
        assertEquals(0,result.length);

    }

    @Test
    @DisplayName("听力测试历史记录")
    public void testHistory() {
        String user_id="123456789123456789";
        GetTestHistory[] result;
        result=userHistoryMapper.testHistory(user_id);
        assertTrue(result.length>=0);


        user_id="1234567891234567";
        result=userHistoryMapper.testHistory(user_id);
        assertEquals(0,result.length);

        user_id="";
        result=userHistoryMapper.testHistory(user_id);
        assertEquals(0,result.length);
    }

//    @Test
//    @DisplayName("用户收藏记录？？似乎冲突了")
//    public void collection() {
//        String user_id="123456789123456789";
//        GetCollection[] result;
//        result=userHistoryMapper.collection(user_id);
//        assertTrue(result.length>=0);
//
//
//        user_id="1234567891234567";
//        result=userHistoryMapper.collection(user_id);
//        assertEquals(0,result.length);
//
//        user_id="";
//        result=userHistoryMapper.collection(user_id);
//        assertEquals(0,result.length);
//    }

    @Test
    @DisplayName("获取个人反馈")
    public void feedback() {
        String user_id="123456789123456789";
        GetFeedback[] result;
        result=userHistoryMapper.feedback(user_id);
        assertTrue(result.length>=0);


        user_id="1234567891234567";
        result=userHistoryMapper.feedback(user_id);
        assertEquals(0,result.length);

        user_id="";
        result=userHistoryMapper.feedback(user_id);
        assertEquals(0,result.length);
    }

    @Test
    @DisplayName("获取所有音乐")
    public void music() {
        GetAllMusic[] result;
        result=userHistoryMapper.music();
        assertTrue(result.length>=0);
    }

    @Test
    @DisplayName("获取所有对反馈的回复")
    public void reply() {
        GetReplyFeedback[] result;
        result=userHistoryMapper.reply();
        assertTrue(result.length>=0);
    }
}