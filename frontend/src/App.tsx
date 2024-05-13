import React from "react";
import logo from "./logo.svg";
import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import OnBoard from "./pages/OnBoard";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" Component={OnBoard} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
