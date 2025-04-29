

import prisma from "@/lib/prisma";

export const dynamic = 'force-dynamic';

async function TodoListPage({searchParams}: {searchParams:Promise<any>} ) {

    const search = await searchParams

    console.log(search)
    const page = search?.page || "1"
    const size = search?.page || "10"

    const data = await prisma.tbl_todo.findMany({
        skip:(Number(page)-1) * Number(size),
        take: Number(size),
        orderBy: {tno: "desc"}
    })

    console.log(data)

    return (
        <div>
            <div className={'text-4xl'}>Todo List Page</div>
        </div>
    )

}

export default TodoListPage