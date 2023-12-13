import { FC, useState } from 'react';

const fieldsetClass = 'w-96 flex justify-between';

const AddRoomModal: FC<{
    onClose: () => void;
}> = ({ onClose }) => {
    const [title, setTitle] = useState('');
    const [description, setDescription] = useState('');
    const [usersToAdd, setUsersToAdd] = useState<number[]>([]);

    const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        // TODO: Make request to server
        console.log(title, description, usersToAdd);
        onClose();
    };
    return (
        <div
            className="absolute flex h-screen w-screen cursor-pointer items-center justify-center bg-stone-800 bg-opacity-95"
            onClick={onClose}
        >
            <div
                className="flex h-1/2 w-1/2 cursor-auto flex-col items-center justify-center rounded-xl bg-stone-100 px-4 py-8"
                onClick={(e) => e.stopPropagation()}
            >
                <h1 className="text-4xl font-bold">Create Room</h1>
                <form
                    onSubmit={handleSubmit}
                    className="flex flex-1 flex-col items-center justify-center gap-4"
                >
                    <fieldset className={`${fieldsetClass}`}>
                        <label>Title: </label>
                        <input
                            type="text"
                            value={title}
                            onChange={(e) => setTitle(e.currentTarget.value)}
                        />
                    </fieldset>
                    <fieldset className={`${fieldsetClass}`}>
                        <label>Description: </label>
                        <input
                            type="text"
                            value={description}
                            onChange={(e) =>
                                setDescription(e.currentTarget.value)
                            }
                        />
                    </fieldset>
                    <fieldset className={`${fieldsetClass}`}>
                        <label>Users to add:</label>
                        <input
                            type="text"
                            onChange={(e) => {
                                setUsersToAdd(
                                    e.currentTarget.value
                                        .split(' ')
                                        .map((id) => parseInt(id))
                                );
                            }}
                        />
                    </fieldset>
                    <button className="w-32 rounded-full bg-emerald-500 px-1 py-2 font-semibold text-white">
                        Create Room
                    </button>
                </form>
            </div>
        </div>
    );
};

export default AddRoomModal;
