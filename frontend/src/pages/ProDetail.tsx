import React, { useState, useEffect } from "react";
import { useLocation } from "react-router-dom";
import Header from "../components/Header";
import CitizenTitle from "../images/citizen_title.png";
import styled from "styled-components";
import RadarChart from "../components/RaderChart";
import CandleChart from "../components/CandleChart";
import UnderBar from "../components/UnderBar";
import OrderModal from "../components/OrderModal";
import axios from "axios"

function ProDetail() {

  const [modalOpen, setModalOpen] = useState(false);

  const tempdate = new Date();
  const [users, setUsers] = useState({
    profile: "",
    name: "",
    birthDay: tempdate,
    nation: "",
    weight: 0,
    height: 0,
    youth: "",
    isGoalkeeper: 0,
    position: "",
  });

  const location = useLocation();

  useEffect(() => {
    console.log(location.pathname.slice(11));
  }, [location]);

  const pro_id = parseInt(location.pathname.slice(11));
  console.log(pro_id);

  useEffect(() => {
    axios.get(`http://localhost:8080/players/${pro_id}`)
      .then(response => {
        console.log(response.data);  // 응답 데이터 확인
        const userData = response.data;
        userData.birthDay = new Date(userData.birthDay); // 문자열을 Date 객체로 변환
        setUsers(userData);
      })
      .catch(error => {
        console.log(error);
      });
  }, [pro_id]);  // pro_id 의존성 추가

  useEffect(() => {
    console.log(users);  // users 상태 변경 시 로그 출력
  }, [users]);


  return (
    <>
      {modalOpen && <OrderModal modalOpen={setModalOpen} modalOpenStatus={modalOpen} />}
      <Header title="대전하나시티즌" />
      <Wrapper>
        <img src={CitizenTitle} alt="title_img" />
        <InfoBox>
          <LeftDiv>
            <img src={users.profile} alt="player_img" />
            <div className="hana-regular">27 {users.position} {users.name}</div>
          </LeftDiv>
          <RightDiv className="font-sans">
            <div>생년월일</div>
            <div>{users.birthDay.getFullYear() + '.' + users.birthDay.getMonth() + '.' + users.birthDay.getDay()}</div>
            <div>국적</div>
            <div>{users.nation}</div>
            <div>신장/체중</div>
            <div>{users.height}cm/{users.weight}kg</div>
            <div>출신교</div>
            <div>{users.youth}</div>
          </RightDiv>
        </InfoBox>
        <ChartContainer>
          <RadarChart />
        </ChartContainer>
        <CandleContainer>
          <p className="hana-medium">
            🚨 <b>20대</b>의 <b>32%</b>가 <b>이승현 토큰</b>을 구매했어요!{" "}
          </p>
          <CandleChart title={true} />
        </CandleContainer>
        <OrderBox className="hana-regular">
          <div>현재 가격</div>
          <div>현재 보유량</div>
        </OrderBox>
        <OrderButton className="hana-bold" onClick={() => setModalOpen(true)}>
          주문하기
        </OrderButton>
      </Wrapper>
      <UnderBar />
    </>
  );
}

export default ProDetail;

export const InfoBox = styled.div`
  display: flex;
  height: 180px;
  border-bottom: 1px solid gray;
  font-size: 0;
  gap: 0;
`;

export const LeftDiv = styled.div`
  width: 132px;
  height: 180px;
  font-size: 0;
  img {
    width: 132px;
    height: 150px;
  }
  div {
    text-align: center;
    background-color: white;
    height: 30px;
    font-size: 16px;
    font-weight: 700;
    line-height: 30px;
  }
`;

export const RightDiv = styled.div`
  width: 299px;
  height: 180px;
  background-color: white;
  display: grid;
  grid-template-columns: 2fr 4fr;
  grid-template-rows: repeat(4, 1fr);
  gap: 10px;
  color: black;
  font-size: 14px;
  align-items: center;
  justify-items: center;
  & > div:nth-child(2n-1) {
    font-weight: 700;
  }
`;

const ChartContainer = styled.div`
  width: 100%;
  height: 270px;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: white;
  padding-top: 20px;
  border-bottom: 1px solid gray;
`;

const CandleContainer = styled.div`
  width: 100%;
  background-color: white;
  text-align: center;
  p {
    margin: 0;
    padding: 5px 0 5px 0;
    background-color: rgba(0, 132, 118, 0.2);
  }
  p > b {
    color: #008476;
  }
`;

const Wrapper = styled.div`
  height: 730px;
  overflow: auto;
  &::-webkit-scrollbar {
    display: none;
  }
`;

const OrderBox = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  div {
    width: 220px;
    height: 44px;
    border-radius: 10px;
    text-align: center;
    line-height: 44px;
    color: white;
  }
`;

const OrderButton = styled.button`
  width: 100%;
  height: 44px;
  margin: 0 auto;
  border: 1px solid gray;
  font-size: 18px;
  background-color: white;
  cursor: pointer;
`;
