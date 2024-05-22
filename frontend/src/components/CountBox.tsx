import React, { useEffect, useState } from "react";
import styled from "styled-components";
import formatMoney from "../util/formatMoney";
import { useStore } from "zustand";
import { usePrice } from "../store/priceStore";

interface CountBoxProps {
  type: "price" | "token";
  size: number;
}

function CountBox({ type, size }: CountBoxProps) {
  const {sto_price, sto_token, setPrice, setToken} = useStore(usePrice);
  const setNowSize = (udtype: "up"|"down") => {
    if (type ==="price") {
      if (udtype === "up") {
        setPrice(sto_price + updownSize)
      } else {
        setPrice(sto_price - updownSize)
      }
    } else {
      if (udtype === "up") {
        setToken(sto_token + 1)
      } else {
        if (sto_token > 0) {
          setToken(sto_token - 1)
        }
      }
    }
  }
  const updownSize = type === "price" ? 100 : 1;
  const unit = type ==="price" ? "원" : "토큰"
  return (
    <Container className="hana-bold">
      <p
        className="hana-regular"
        style={{ fontSize: 40, fontWeight: 300, cursor: "pointer" }}
        onClick={() => {
          setNowSize("down")
        }}
      >
        -
      </p>
      <p className="hana-bold">{formatMoney(size)}{unit}</p>
      <p
        className="hana-regular"
        style={{ fontSize: 40, fontWeight: 300, cursor: "pointer" }}
        onClick={() => setNowSize("up")}
      >
        +
      </p>
    </Container>
  );
}

export default CountBox;

const Container = styled.div`
  display: flex;
  width: 90%;
  height: 70px;
  justify-content: space-around;
  align-items: center;
  border: 1px solid black;
  border-radius: 5px;
  font-size: 22px;
  font-weight: 500;
  user-select: none;
`;
