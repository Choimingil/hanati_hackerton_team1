import {create} from "zustand";

interface usePriceProps {
    sto_price: number,
    sto_token: number;
    setPrice: (newPrice: number) => void;
    setToken: (newToken: number) => void;
  }

  const usePrice = create<usePriceProps>(set => ({
    sto_price: 0,
    sto_token: 0,
    setPrice: (newPrice: number) => {
        set({sto_price: newPrice})
    },
    setToken: (newPrice: number) => {
        set({sto_token: newPrice})
    }
  }));
  
  export { usePrice };