import React, {useState} from "react";
import Header from "../components/Header";
import CitizenTitle from "../images/citizen_title.png";
import styled from "styled-components";
import RadarChart from "../components/RaderChart";
import CandleChart from "../components/CandleChart";
import UnderBar from "../components/UnderBar";
import OrderModal from "../components/OrderModal";

function ProDetail() {
    const [modalOpen, setModalOpen] = useState(true);
  return (
    <>
    {modalOpen && <OrderModal modalOpen={setModalOpen}/>}
      <Header title="대전하나시티즌" />
      <Wrapper>
        <img src={CitizenTitle} alt="title_img" />
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
            <div>출신교</div>
            <div>한솔고등학교</div>
          </RightDiv>
        </InfoBox>
        <ChartContainer>
          <RadarChart />
        </ChartContainer>
        <CandleContainer>
          <p className="hana-medium">
            🚨 <b>20대</b>의 <b>32%</b>가 <b>이승현 토큰</b>을 구매했어요!{" "}
          </p>
          <CandleChart />
        </CandleContainer>
        <OrderBox className="hana-regular">
          <div>현재 가격</div>
          <div>현재 보유량</div>
        </OrderBox>
        <OrderButton className="hana-bold" onClick={()=>setModalOpen(true)}>주문하기</OrderButton>
      </Wrapper>
      <UnderBar />
    </>
  );
}

export default ProDetail;

const InfoBox = styled.div`
  display: flex;
  height: 180px;
  border-bottom: 1px solid gray;
  font-size: 0;
  gap: 0;
`;

const LeftDiv = styled.div`
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

const RightDiv = styled.div`
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
