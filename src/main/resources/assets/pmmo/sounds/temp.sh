#!/bin/bash
#public static final RegistryObject<SoundEvent> AGILITY_1 = SOUND_EVENTS.register("agility_1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,"agility_1")) );
for raw in *.ogg; do
	name=${raw%'.ogg'}
	echo -e "public static final RegistryObject<SoundEvent> ${name^^} = SOUND_EVENTS.register(\"$name\", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID,\"$name\")));" >>output
done
