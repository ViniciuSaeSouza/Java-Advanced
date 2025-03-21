import CategoryItem from "@/components/category-item";
import NavBar from "@/components/nav-bar";

export default function CategoriesPage() {
  return (
    <>
    <NavBar active="categorias"/>
      <main className="flex items-center justify-center">
        <div className="bg-slate-800 rounded min-w-2/3 p-6 m-6">
          <h2 className="text-lg font-bold">Categorias</h2>
		  <CategoryItem/>
		  <CategoryItem/>
		  <CategoryItem/>
        </div>
      </main>
    </>
  );
}
