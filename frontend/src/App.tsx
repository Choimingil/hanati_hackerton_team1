import React from "react";
import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import OnBoard from "./pages/OnBoard";
import Main from "./pages/Main";
import RegistProspect from "./pages/RegistProspect";
import ProList from "./pages/ProList";
import ProDetail from "./pages/ProDetail";
import ProspectList from "./pages/ProspectList";
import ProspectDetail from "./pages/ProspectDetail";
import Mypage from "./pages/Mypage";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" Component={OnBoard} />
        <Route path="/main" Component={Main} />
        <Route path="/registProspect" Component={RegistProspect} />
        <Route path="/proList" Component={ProList} />
        <Route path="/proDetail/:id" Component={ProDetail} />
        <Route path="/prospectList" Component={ProspectList} />
        <Route path="/prospectDetail/:id" Component={ProspectDetail} />
        <Route path="/mypage" Component={Mypage} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
