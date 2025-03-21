import CategoryItem from "@/components/category-item";
import NavBar from "@/components/nav-bar";
import { icons } from "lucide-react";

async function getCategories() {
    const response = await fetch("http://localhost:8080/categories");
    return await response.json();
}



export default async function CategoriesPage() {
	const data:Array<Category> = await getCategories();	
	return (
        <>
            <NavBar active="categorias" />
            <main className="flex items-center justify-center">
                <div className="bg-slate-800 rounded min-w-2/3 p-6 m-6">
                    <h2 className="text-lg font-bold">Categorias</h2>
                    {data.map((category) => (
                        <CategoryItem category={category} key={category.id} />
                    ))}
					
                </div>
            </main>
        </>
    );
}
