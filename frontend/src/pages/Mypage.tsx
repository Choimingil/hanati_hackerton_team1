import React from "react";
import Header from "../components/Header";
import { TeamTitle } from "./ProList";
import Amblem from "../f_images/amblem/hana_citizen_amblem.png";
import styled from "styled-components";
import UnderBar from "../components/UnderBar";
import PieChart from "../components/PieChart";
import CandleChart from "../components/CandleChart";
import formatMoney from "../util/formatMoney";

function Mypage() {
  return (
    <>
      <Header title="마이페이지" />
      <Wrapper>
        <TeamTitle>
          <img src={Amblem} alt="title_img" />
          <p className="hana-bold">김하나</p>
        </TeamTitle>
        <p className="hana-regular">하나은행 계좌로 거래하면 더 많은 혜택을 받을 수 있어요.</p>
        <Button className="hana-bold">연동하기</Button>
        <PieChartContainer>
          <p className="hana-medium">나의 총 자산 : {formatMoney(37281)}원</p>
          <PieChart />
        </PieChartContainer>
        <CandleChartContainer>
          <p className="hana-medium">나의 투자 현황</p>
          <CandleChart title={false} />
        </CandleChartContainer>
      </Wrapper>
      <UnderBar />
    </>
  );
}

export default Mypage;
const Wrapper = styled.div`
  background-color: white;
  text-align: center;
  height: 730px;
  overflow: scroll;
`;

const Button = styled.button`
  width: 90%;
  height: 50px;
  line-height: 50px;
  text-align: center;
  border-radius: 10px;
  border: none;
  background-color: #008476;
  color: white;
  font-size: 18px;
  cursor: pointer;
`;

const PieChartContainer = styled.div`
  width: 430px;
  height: 270px;
  text-align: left;
  p {
    margin-left: 30px;
    font-size: 18px;
  }
`;

const CandleChartContainer = styled.div`
  width: 430px;
  height: 270px;
  text-align: left;
  p {
    margin-left: 30px;
    font-size: 18px;
  }
`;
