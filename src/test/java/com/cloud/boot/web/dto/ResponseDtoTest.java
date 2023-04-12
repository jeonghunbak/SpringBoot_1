package com.cloud.boot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ResponseDtoTest {

    @Test
    public void lombokTest(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        ResponseDto dto = new ResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
