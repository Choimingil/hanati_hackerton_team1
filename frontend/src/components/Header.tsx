import React from "react";
import styled from "styled-components";

interface HeadProps {
  title: string;
}

function Header({ title }: HeadProps) {
  return <HeadWrapper className="hana-bold">{title}</HeadWrapper>;
}

export default Header;

const HeadWrapper = styled.div`
  width: 100%;
  height: 34px;
  background-color: #008476;
  display: flex;
  justify-content: center;
  align-items: center;
  color: white;
`;
