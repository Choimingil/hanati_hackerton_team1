import React, { useState } from "react";
import Header from "../components/Header";
import { InfoBox, LeftDiv, RightDiv } from "./ProDetail";
import styled from "styled-components";
import UnderBar from "../components/UnderBar";
import YouTube from "react-youtube";
import SubScribeModal from "../components/SubScribeModal";

function ProspectDetail() {
  const [isSub, setIsSub] = useState(false); // 구독여부 받아서 수정
  const [modalOpen, setModalOpen] = useState(false);

  const subMessage = isSub ? "구독취소" : "구독하기";
  const videoId = "fg_lI0UMTDs";
  const opts = {
    height: "250",
    width: "430",
    playerVars: {
      autoplay: 1,
    },
  };
  return (
    <>
      {modalOpen && <SubScribeModal modalOpen={setModalOpen} modalStatus={modalOpen}/>}
      <Header title="유망주" />
      <Wrapper>
        <InfoBox>
          <LeftDiv>
            <img src="/img/pro_temp_img.png" alt="player_img" />
            <div className="hana-regular">30 ST 이승현</div>
          </LeftDiv>
          <RightDiv className="font-sans">
            <div>생년월일</div>
            <div>1998.06.17</div>
            <div>국적</div>
            <div>대한민국</div>
            <div>신장/체중</div>
            <div>170cm/67kg</div>
            <div>출신고교/유스</div>
            <div>한솔고등학교</div>
          </RightDiv>
        </InfoBox>
        <ApealDiv>
          <TextBox>
            <span className="hana-bold">나의 비전</span>
            <p className="hana-regular">열시미 하겠습니다</p>
          </TextBox>
          <TextBox>
            <span className="hana-bold">비전을 위한 노력</span>
            <p className="hana-regular">열시미 하겠습니다</p>
          </TextBox>
          <TextBox>
            <span className="hana-bold">장점</span>
            <p className="hana-regular">열시미 하겠습니다</p>
          </TextBox>
        </ApealDiv>
        <VideoBox>
          <YouTube videoId={videoId} opts={opts} />
        </VideoBox>
        <SubDiv
          className={isSub ? "sub hana-bold" : "not-sub hana-bold"}
          onClick={() => {
            setIsSub(prev => !prev);
            setModalOpen(true);
          }}
        >
          {subMessage}
        </SubDiv>
      </Wrapper>
      <UnderBar />
    </>
  );
}

export default ProspectDetail;

const ApealDiv = styled.div`
  display: flex;
  flex-direction: column;
  height: 400px;
  width: 100%;
  padding: 20px 0;
  padding-left: 3.5%;
  gap: 20px;
  background-color: white;
`;

const TextBox = styled.div`
  width: 90%;
  height: 120px;
  border: 1px solid black;
  border-radius: 10px;
  padding: 5px;
  p {
    margin-top: 5px;
  }
`;

const Wrapper = styled.div`
  height: 730px;
  overflow: auto;
  &::-webkit-scrollbar {
    display: none;
  }
`;

const VideoBox = styled.div`
  width: 100%;
  height: 250px;
`;

const SubDiv = styled.div`
  width: 100%;
  height: 60px;
  text-align: center;
  line-height: 60px;
  font-size: 22px;
  color: white;
  cursor: pointer;
  border-bottom: 2px solid white;
  &.sub {
    background-color: #a12641;
  }
  &.not-sub {
    background-color: #008476;
  }
`;
