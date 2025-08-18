import { link } from "fs";
import Link from "next/link";
import React from "react";

interface NavBarProps {
  active: "dashboard" | "movimentações" | "categorias";
}

export default function NavBar(props: NavBarProps) {
  const { active } = props;

  const activeClass = "border-b-2 border-green-600 pb-4";

  const links = [
    { link: "/dashboard", label: "dashboard" },
    { link: "/transactions", label: "movimentações" },
    { link: "/categories", label: "categorias" },
  ];

  return (
    <nav className="flex bg-slate-800 justify-between items-center px-6 pt-6">
      <h1 className="text-4xl font-bold">FinMoney</h1>
      <ul className="flex gap-6 text-xl">
        {links.map((l) => 
          
            <li key={l.label} className={l.label === active ? activeClass : ""}>
              <Link href={l.link}>{l.label.toUpperCase()}</Link>
            </li>
          
        )}
      </ul>
      <img
        className="size-12 rounded-full"
        src="http://github.com/viniciusaesouza.png"
        alt="imagem de um cara muito gato"
      />
    </nav>
  );
}
