import React, { useEffect, useState } from "react";
import Header from "../components/Header";
import { InfoBox, LeftDiv, RightDiv } from "./ProDetail";
import styled from "styled-components";
import UnderBar from "../components/UnderBar";
import YouTube from "react-youtube";
import SubScribeModal from "../components/SubScribeModal";
import { useLocation } from "react-router-dom";
import axios from "axios";
import { useStore } from "zustand";
import { usePrice } from "../store/priceStore";

function ProspectDetail() {
    const {sto_price, sto_token, setPrice, setToken} = useStore(usePrice);

  const [isSub, setIsSub] = useState(false); // 구독여부 받아서 수정
  const [modalOpen, setModalOpen] = useState(false);
  const [userId, setUserId] = useState(0);
  const [user, setUser] = useState({
    profile: "",
    name: "",
    birthDate: new Date(),
    nation: "",
    weight: 0,
    height: 0,
    vision: "",
    effort: "",
    advantage: "",
    video: "",
    position: "",
    isSubscribed: true,
    youth: "",
  });

  const subMessage = user.isSubscribed ? "구독취소" : "구독하기";
  const modalMessage = user.isSubscribed ? "구독이 취소되었습니다." : "구독이 완료되었습니다.";
  const videoId = "fg_lI0UMTDs";
  const opts = {
    height: "250",
    width: "430",
    playerVars: {
      autoplay: 1,
    },
  };
  const location = useLocation();
  const user_id = parseInt(location.pathname.split("/")[2]);
  useEffect(() => {
    axios.get(`http://localhost:8080/prospects/${user_id}`).then(response => {
      const userData = response.data;
      userData.birthDate = new Date(userData.birthDate);
      console.log(userData);
      setUser(userData);
      setPrice(userData.price);
      // setIsSub(userData.isSubscribed);
    });
  }, [user_id]);
  const updateSubscribe = () => {
    if (user.isSubscribed) {
      //구독한 상태라면
      axios
        .delete(`http://localhost:8080/prospects/${user_id}/subscribe`)
        .then(res => user.isSubscribed = !user.isSubscribed)
        .catch(err => console.log(err));
    } else {
      // 아니라면
      axios
        .post(`http://localhost:8080/prospects/${user_id}/subscribe`)
        .then(res => user.isSubscribed = !user.isSubscribed)
        .catch(err => console.log(err));
    }
  };
  return (
    <>
      {modalOpen && <SubScribeModal modalOpen={setModalOpen} modalStatus={modalOpen} message={modalMessage} />}
      <Header title="유망주" />
      <Wrapper>
        <InfoBox>
          <LeftDiv>
            <img src={user.profile} alt="player_img" />
            <div className="hana-regular">
              {user.position} {user.name}
            </div>
          </LeftDiv>
          <RightDiv className="font-sans">
            <div>생년월일</div>
            <div>{user.birthDate.getFullYear() + "." + user.birthDate.getMonth() + "." + user.birthDate.getDay()}</div>
            <div>국적</div>
            <div>{user.nation}</div>
            <div>신장/체중</div>
            <div>
              {user.height}cm/{user.weight}kg
            </div>
            <div>출신고교/유스</div>
            <div>{user.youth}</div>
          </RightDiv>
        </InfoBox>
        <ApealDiv>
          <TextBox>
            <span className="hana-bold">나의 비전</span>
            <p className="hana-regular">{user.vision}</p>
          </TextBox>
          <TextBox>
            <span className="hana-bold">비전을 위한 노력</span>
            <p className="hana-regular">{user.effort}</p>
          </TextBox>
          <TextBox>
            <span className="hana-bold">장점</span>
            <p className="hana-regular">{user.advantage}</p>
          </TextBox>
        </ApealDiv>
        <VideoBox>
          <YouTube videoId={videoId} opts={opts} />
        </VideoBox>
        <SubDiv
          className={user.isSubscribed ? "sub hana-bold" : "not-sub hana-bold"}
          onClick={() => {
            setModalOpen(true);
            updateSubscribe();
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
