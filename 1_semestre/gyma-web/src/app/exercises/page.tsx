import ExercicesItem from "@/components/exercises-item";
import Navbar from "@/components/navbar";
import { Button } from "@/components/ui/button";
import { Plus } from "lucide-react";

async function getExercises(){
    const response = await fetch("http://localhost:8080/exercises")
    return await response.json()
}

export default async function ExercisesPage() {
    const data: Array<Exercise> = await getExercises()

    return(
    <>
    <Navbar active="Treinos"/>

    <main className="flex items-center justify-center">
        <div className=" bg-slate-900 rounded min-w-2/3 p-5 m-6">
            <div className="flex justify-between">
				<h2 className="text-lg font-bold text-white ">Treinos</h2>
				<Button asChild className="cursor-pointer">
					<div><Plus/>Novo Treino</div>
				</Button>
			</div>

            { data.map( exercices=> <ExercicesItem key={exercices.id} exercise={exercices} /> ) }
            
        </div>
    </main>
    </>
    )
}

