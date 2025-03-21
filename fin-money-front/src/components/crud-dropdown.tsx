import React from "react";
import {
    DropdownMenu,
    DropdownMenuContent,
    DropdownMenuItem,

    DropdownMenuTrigger,
} from "@/components/ui/dropdown-menu";
import { ChevronDown, Pencil, Trash } from "lucide-react";

export default function CrudDropdown() {
    return (
        <DropdownMenu>
            <DropdownMenuTrigger>
                <ChevronDown />
            </DropdownMenuTrigger>
            <DropdownMenuContent>
                {/* <DropdownMenuLabel>My Account</DropdownMenuLabel> */}
                {/* <DropdownMenuSeparator /> */}
                <DropdownMenuItem><Pencil/> Editar</DropdownMenuItem>
                <DropdownMenuItem><Trash/> Apagar</DropdownMenuItem>
            </DropdownMenuContent>
        </DropdownMenu>
    );
}
