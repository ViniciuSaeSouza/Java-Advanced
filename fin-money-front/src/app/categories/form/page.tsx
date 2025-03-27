"use client"
import NavBar from "@/components/nav-bar";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import Link from "next/link";
import { createCategory } from "@/actions/category-actions";
import { useActionState } from "react";

const initialState = {
  value: {
    name: "",
    icon: "",
  },
};

export default function CategoriesForm() {
  const [state, formAction, pending] = useActionState(
    createCategory,
    initialState
  );
  return (
    <>
      <NavBar active="categorias" />
      <main className="flex items-center justify-center">
        <div className="bg-slate-900 rounded p-5 m-6 max-w-[500px]">
          <h2 className="font-bold">Cadastrar categoria</h2>
          <form action={formAction} className="space-y-4 mt-6">
            <Input name="name" placeholder="nome da categoria" />
            <Input name="icon" placeholder="Ícone" />
            <div className="flex justify-around">
              <Button asChild variant="outline">
                <Link href="/categories">Cancelar</Link>
              </Button>
              <Button>Salvar</Button>
            </div>
          </form>
        </div>
      </main>
    </>
  );
}
