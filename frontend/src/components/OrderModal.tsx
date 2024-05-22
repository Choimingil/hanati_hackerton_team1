import React, { Dispatch, SetStateAction, useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import styled, { keyframes } from "styled-components";
import CountBox from "./CountBox";
import MenuItem from "@mui/material/MenuItem";
import FormControl from "@mui/material/FormControl";
import Select, { SelectChangeEvent } from "@mui/material/Select";
import formatMoney from "../util/formatMoney";
import Character from "../f_images/character.png";
import axios from "axios"

interface ChildProps {
  modalOpen: React.Dispatch<React.SetStateAction<boolean>>;
  modalOpenStatus: boolean;
}
interface modalProps {
  orderStatus: boolean;
}




function OrderModal({ modalOpen, modalOpenStatus }: ChildProps) {
  const [way, setWay] = useState("");

  const [orderStatus, setOrderStatus] = useState(false);
  const [isModalOpen, setIsModalOpen] = useState(true);
  const [totalprice, setTotalprice] = useState(0);
  const location = useLocation();
  const pro_id = location.pathname.slice(11);
  const handleChange = (event: SelectChangeEvent) => {
    setWay(event.target.value);
  };
  const handleModal = (e: React.MouseEvent) => {
    e.stopPropagation();

  };
  useEffect(() => {
    if (orderStatus) {
      const timer = setTimeout(() => {
        setOrderStatus(false);
        modalOpen(false);
      }, 3000);
      setIsModalOpen(false);
      return () => clearTimeout(timer);
    }
  }, [orderStatus]);
  return (
    <>
      {orderStatus && (
        <OrderFinModal orderStatus={orderStatus}>
          <img src={Character} alt="character" />
          <p className="hana-bold">주문이 체결되었습니다.</p>
        </OrderFinModal>
      )}
      <Overlay onClick={() => modalOpen(false)}>
        {isModalOpen && (
          <Modal onClick={handleModal}>
            <TopBox className="hana-bold">
              <div style={{ color: "#008476" }}>매수</div>
              <div>매도</div>
              <div>미체결</div>
            </TopBox>
            <OptionContainer>
              <FormControl sx={{ m: 1, minWidth: "70%", border: "1px solid black", borderRadius: 2 }}>
                <Select
                  className="hana-bold"
                  value={way}
                  onChange={handleChange}
                  displayEmpty
                  inputProps={{ "aria-label": "Without label" }}
                >
                  <MenuItem value="">
                    <em>지정가</em>
                  </MenuItem>
                  <MenuItem value={10}>지정가</MenuItem>
                  <MenuItem value={20}>시장가</MenuItem>
                  <MenuItem value={30}>시간외종가</MenuItem>
                  <MenuItem value={30}>시간외단일가</MenuItem>
                </Select>
              </FormControl>
              <div className="point-box hana-bold">시장가</div>
            </OptionContainer>
            <CountContainer>
              <CountBox type="price" size={27812} />
              <CountBox type="token" size={0} />
            </CountContainer>
            <ResultBox className="hana-bold">
              <FlexBox>
                <p>매수가능금액</p>
                <p>{formatMoney(54252)}원</p>
              </FlexBox>
              <FlexBox>
                <p>주문금액</p>
                <p>0원</p>
              </FlexBox>
            </ResultBox>
            <BuyButton className="hana-regular" onClick={() => {
              setOrderStatus(true);

              const data = {
                tokenPrice: 100000,
                tokenCount: 18,
              };
              axios.post(`http://localhost:8080/players/${pro_id}/buy`, data);
            }}>
              현금매수
            </BuyButton>
          </Modal>
        )}
      </Overlay>
    </>
  );
}

export default OrderModal;

export const Overlay = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  position: absolute;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  background-color: rgba(0, 0, 0, 0.7);
  z-index: 2;
`;

const Modal = styled.div`
  width: 376px;
  height: 620px;
  background-color: white;
  border-radius: 10px;
  z-index: 3;
`;

const TopBox = styled.div`
  display: flex;
  justify-content: space-around;
  div {
    height: 60px;
    line-height: 60px;
  }
  &:first-child {
    border-bottom: 2px solid black;
  }
`;

const CountContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  gap: 20px;
  padding: 20px 0;
`;

const OptionContainer = styled.div`
  width: 90%;
  height: 50px;
  padding: 20px 0;
  margin: 0 auto;
  display: flex;
  justify-content: space-between;
  align-items: center;
  .option-box {
    width: 70%;
    height: 50px;
    border: 1px solid black;
    border-radius: 5px;
  }
  .point-box {
    width: 20%;
    height: 50px;
    border: 1px solid black;
    border-radius: 5px;
    line-height: 50px;
    text-align: center;
  }
`;

const ResultBox = styled.div`
  padding: 20px;
`;

const FlexBox = styled.div`
  display: flex;
  justify-content: space-between;
`;

const BuyButton = styled.button`
  width: 90%;
  height: 60px;
  background-color: red;
  line-height: 60px;
  text-align: center;
  color: white;
  margin-left: 5%;
  font-size: 20px;
  border: none;
  border-radius: 10px;
  cursor: pointer;
`;

const OrderFinModal = styled.div<modalProps>`
  width: 430px;
  height: 150px;
  display: flex;
  align-items: center;
  justify-content: space-around;
  background-color: white;
  position: absolute;
  top: 50%;
  transform: translateY(-60%);
  z-index: 5;
  animation: ${props => (props.orderStatus ? fadeIn : fadeOut)} 0.5s forwards;
  color: black;
  img {
    height: 130px;
  }
  font-size: 22px;
`;

export const fadeIn = keyframes`
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
`;

const fadeOut = keyframes`
  from {
    opacity: 1;
  }
  to {
    opacity: 0;
  }
`;
