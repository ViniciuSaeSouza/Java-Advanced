import React from "react";

export default function NavBar() {
  return (
    <nav className="flex bg-slate-800 justify-between items-center px-6 pt-6">
      <h1 className="text-4xl font-bold">FinMoney</h1>
      <ul className="flex gap-6 text-xl">
        <li>
          <a href="#">Dashboard</a>
        </li>
        <li>
          <a href="#">Movimentações</a>
        </li>
        <li className="border-b-2 border-green-600 pb-4">
          <a href="#">Categorias</a>
        </li>
      </ul>
      <img
        className="size-12 rounded-full"
        src="http://github.com/viniciusaesouza.png"
        alt="imagem de um cara muito gato"
      />
    </nav>
  );
}
