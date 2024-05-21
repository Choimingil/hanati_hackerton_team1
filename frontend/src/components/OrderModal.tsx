import React, { Dispatch, SetStateAction } from "react";
import styled from "styled-components";
import CountBox from "./CountBox";
import MenuItem from "@mui/material/MenuItem";
import FormControl from "@mui/material/FormControl";
import Select, { SelectChangeEvent } from "@mui/material/Select";
import formatMoney from "../util/formatMoney";

interface ChildProps {
    modalOpen: React.Dispatch<React.SetStateAction<boolean>>;
  }

function OrderModal({modalOpen}:ChildProps) {
  const [way, setWay] = React.useState("");
  const handleChange = (event: SelectChangeEvent) => {
    setWay(event.target.value);
  };
  const handleModal = (e: React.MouseEvent) => {
    e.stopPropagation();
  }
  return (
    <Overlay onClick={() => modalOpen(false)} >
      <Modal onClick={handleModal}>
        <TopBox className="hana-bold">
          <div style={{ color: "#008476" }}>매수</div>
          <div>매도</div>
          <div>미채결</div>
        </TopBox>
        <OptionContainer>
          <FormControl sx={{ m: 1, minWidth: "70%", border: "1px solid black", borderRadius: 2 }}>
            <Select className="hana-bold" value={way} onChange={handleChange} displayEmpty inputProps={{ "aria-label": "Without label" }}>
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
        <BuyButton className="hana-regular">현금매수</BuyButton>
      </Modal>
    </Overlay>
  );
}

export default OrderModal;

const Overlay = styled.div`
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
