import React from "react";
import TeamDiv from "../components/TeamDiv";
import styled from "styled-components";
import {
  hanaAmblem,
  seoulAmblem,
  jeonbukAmblem,
  gangwonAmblem,
  gyungnamAmblem,
  incheonAmblem,
  suwonAmblem,
  ulsanAmblem,
} from "../util/imageSource";
import Header from "../components/Header";
import SearchBar from "../components/SearchBar";
import Carousel from "../components/Carousel";
import UnderBar from "../components/UnderBar";

function Main() {
  return (
    <>
      <Head>
        <Header title="팀목록" />
        <Carousel />
        <SearchBar />
      </Head>
      <TeamWrapper>
        <TeamDiv teamLogo={hanaAmblem} teamName="대전하나시티즌" />
        <TeamDiv teamLogo={seoulAmblem} teamName="FC서울" />
        <TeamDiv teamLogo={jeonbukAmblem} teamName="전북 현대 모터스" />
        <TeamDiv teamLogo={gangwonAmblem} teamName="강원 FC" />
        <TeamDiv teamLogo={gyungnamAmblem} teamName="경남 FC" />
        <TeamDiv teamLogo={incheonAmblem} teamName="인천 유나이티드 FC" />
        <TeamDiv teamLogo={suwonAmblem} teamName="수원 FC" />
        <TeamDiv teamLogo={ulsanAmblem} teamName="울산 HD FC" />
      </TeamWrapper>
      <UnderBar />
    </>
  );
}

export default Main;

const TeamWrapper = styled.div`
  display: flex;
  flex-direction: column;
  height:450px;
  padding: 0px 10px 10px 10px;
  gap: 3px;
  background-color: white;
  overflow: scroll;
  div {
    cursor: pointer;
  }
`;

const Head = styled.div`
  position: sticky;
  top: 0;
  background-color: white;
`;
